package com.tcfeng.starter.app.service;

import com.tcfeng.starter.app.common.vo.ResponseVO;
import com.tcfeng.starter.app.response.UserResponseVO;

public interface ServerService {

    public ResponseVO<UserResponseVO> getStatusById(String serverId);
    
}
