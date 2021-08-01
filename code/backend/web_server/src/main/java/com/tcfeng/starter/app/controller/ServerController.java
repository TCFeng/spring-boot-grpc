package com.tcfeng.starter.app.controller;
 
import com.tcfeng.starter.app.common.vo.ResponseVO;
import com.tcfeng.starter.app.response.UserResponseVO;
import com.tcfeng.starter.app.service.ServerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
 
@Api(tags = "Server")
@CrossOrigin
@RestController
public class ServerController {
 
    @Autowired
    private ServerService serverService;
 
    @ApiOperation(value = "Get User info by ID")
    @ApiResponses({@ApiResponse(code = 422, message = "Error Test Example")})
    @GetMapping("/server/getStatusById")
    public ResponseEntity<ResponseVO<UserResponseVO>> getStatusById(@RequestParam(required = true, value = "serverId") String serverId) {
        return new ResponseEntity<>(this.serverService.getStatusById(serverId), HttpStatus.OK);
    }
 
}