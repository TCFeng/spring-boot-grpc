package com.tcfeng.grpc.app.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerStatusResponseVO {
    
    private String serverId;

    private String status;

    private Date sendTime;

    private Date receiveTime;

}