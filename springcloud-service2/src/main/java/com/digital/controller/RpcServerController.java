package com.digital.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digital.api.RpcServerService;
import com.digital.entity.UserEntity;

@RestController
public class RpcServerController {
    @Autowired
    RpcServerService rpcserverservice;
    @RequestMapping(value = "/useractiondo")
    public String userActiondo(HttpServletRequest request){             //拦截用户发送的/useraction请求
    	long start = System.currentTimeMillis();
    	UserEntity ue=new UserEntity();
    	ue.setUserid("111");
    	ue.setUser("aaa");
    	ue.setPassword("111");
    	HttpSession session = request.getSession();  
        String name=session.getAttribute("name").toString();
        String result=rpcserverservice.userAction(name,ue);
        long end = System.currentTimeMillis();
        System.out.println("forJava: " + (end - start));
    	return result;
    }
  
}