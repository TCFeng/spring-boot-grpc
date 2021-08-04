package com.tcfeng.grpc.app.controller;
 
import com.tcfeng.grpc.app.common.vo.ResponseVO;
import com.tcfeng.grpc.app.response.ServerStatusResponseVO;
import com.tcfeng.grpc.app.service.ServerService;

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
 
    @ApiOperation(value = "Get Server Status by ID")
    @ApiResponses({@ApiResponse(code = 422, message = "Error Test Example")})
    @GetMapping("/server/getStatusById")
    public ResponseEntity<ResponseVO<ServerStatusResponseVO>> getStatusById(@RequestParam(required = true, value = "serverId") String serverId) {
        return new ResponseEntity<>(this.serverService.getStatusById(serverId), HttpStatus.OK);
    }
 
}