package com.tcfeng.grpc.app.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class GrpcClient {

    @Value("${grpc.client.host}")
    private String host;
    @Value("${grpc.client.port}")
    private Integer port;

    public ManagedChannel getChannel(){
        return ManagedChannelBuilder.forAddress(host,port)
                .disableRetry()
                .idleTimeout(2, TimeUnit.SECONDS)
                .usePlaintext()
                .build();
    }
}
