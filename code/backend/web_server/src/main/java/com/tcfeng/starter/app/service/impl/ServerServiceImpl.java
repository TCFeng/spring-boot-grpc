package com.tcfeng.starter.app.service.impl;

import com.tcfeng.starter.app.common.vo.ResponseVO;
import com.tcfeng.starter.app.response.UserResponseVO;
import com.tcfeng.starter.app.service.ServerService;
import com.tcfeng.starter.app.utils.ObjectMapperUtils;

import org.springframework.stereotype.Service;

@Service
public class ServerServiceImpl implements ServerService {


    /**
     * Get User By ID
     */
    @Override
    public ResponseVO<UserResponseVO> getStatusById(String serverId) {

        // S

        return new ResponseVO.Builder<UserResponseVO>().data(null).build();

    }
}