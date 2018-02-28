package com.digital.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.digital.entity.UserEntity;
import com.digital.service.RpcServerServiceError;


@FeignClient(value = "service-rpc1",fallback = RpcServerServiceError.class) //调用注册的rpc-client服务
public interface RpcServerService {
    @RequestMapping(value = "/useraction",method = RequestMethod.GET)
    public String userAction(@RequestParam("name") String name,@RequestBody(required=false) UserEntity ue);//调方法的参数
}