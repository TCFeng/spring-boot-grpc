package com.tcfeng.grpc.app.grpc;

import java.util.Date;

import com.tcfeng.starter.protobuf.health.HealthCheckRequestVO;
import com.tcfeng.starter.protobuf.health.HealthCheckResponseVO;
import com.tcfeng.starter.protobuf.health.HealthGrpc;
import com.tcfeng.starter.protobuf.health.HealthCheckResponseVO.ServingStatus;

import org.lognet.springboot.grpc.GRpcService;

import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j2;


@GRpcService
public class HeartbeatController extends HealthGrpc.HealthImplBase {

    @Override
    public void check(HealthCheckRequestVO requestVO, StreamObserver<HealthCheckResponseVO> responseObserver) {

        Date reveiveTime = new Date();

        HealthCheckResponseVO response = HealthCheckResponseVO.newBuilder().setStatus(ServingStatus.SERVING).setReceiveTime(reveiveTime.getTime()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
