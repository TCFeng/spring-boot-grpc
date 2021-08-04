package com.tcfeng.grpc.app.service;

import com.tcfeng.grpc.app.common.vo.ResponseVO;
import com.tcfeng.grpc.app.response.ServerStatusResponseVO;

public interface ServerService {

    public ResponseVO<ServerStatusResponseVO> getStatusById(String serverId);
    
}
