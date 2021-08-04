package com.tcfeng.grpc.app.service.impl;

import java.util.Date;

import com.tcfeng.grpc.app.common.vo.ResponseVO;
import com.tcfeng.grpc.app.config.GrpcClient;
import com.tcfeng.grpc.app.response.ServerStatusResponseVO;
import com.tcfeng.grpc.app.service.ServerService;
import com.tcfeng.starter.protobuf.health.HealthCheckRequestVO;
import com.tcfeng.starter.protobuf.health.HealthCheckResponseVO;
import com.tcfeng.starter.protobuf.health.HealthGrpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.grpc.ManagedChannel;
import net.badata.protobuf.converter.Converter;

@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    private GrpcClient grpcClient;


    /**
     * Get User By ID
     */
    @Override
    public ResponseVO<ServerStatusResponseVO> getStatusById(String serverId) {

        // 利用GRPC呼叫Server
        ServerStatusResponseVO result = new ServerStatusResponseVO();
        ManagedChannel managedChannel = grpcClient.getChannel();
        Date sendTime = new Date();
        try {
            final HealthGrpc.HealthBlockingStub healthBlockingStub = HealthGrpc.newBlockingStub(managedChannel);
            HealthCheckResponseVO response = healthBlockingStub.check(HealthCheckRequestVO.newBuilder().setService(serverId).setSendTime(sendTime.getTime()).build());
            // result = Converter.create().toDomain(ServerStatusResponseVO.class, response);
            // projectInfoVO.setVersion(version);
            // return projectInfoVO;
            result.setServerId(serverId);
            result.setReceiveTime(new Date(response.getReceiveTime()));
            result.setSendTime(sendTime);
            result.setStatus(response.getStatus().name());
        } finally {
            // 一定要在 finally 中把 gRPC client 的 channel 關閉，避免 resource leak
            if (!managedChannel.isShutdown()) {
                managedChannel.shutdown();
            }
        }

        return new ResponseVO.Builder<ServerStatusResponseVO>().data(result).build();

    }
}