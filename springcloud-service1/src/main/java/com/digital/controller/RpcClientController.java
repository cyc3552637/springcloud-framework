package com.digital.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digital.api.UserService;
import com.digital.entity.UserEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class RpcClientController {
	private static Logger log=LoggerFactory.getLogger(RpcClientController.class);
    @Autowired
    UserService userservice;
    @RequestMapping(value = "/useraction")
    public String userAction(HttpServletRequest request,@RequestParam(value="name",required=false) String name,@RequestBody(required=false) UserEntity ue){  //拦截用户发送的/useraction请求
    	if(ue!=null){
    	log.info(ue.getUser().toString());}
    	else{
    		log.info("null");
    	}
    	if(name==null){
    	HttpSession session = request.getSession();  
        name=session.getAttribute("name").toString();
        log.info("namenull");}
    	else{
    		log.info(name);
    	}
    	return userservice.query(name);
    }
    @RequestMapping(value = "/session")
    public String setSession(HttpServletRequest request){             //拦截用户发送的/useraction请求
    	HttpSession session = request.getSession();  
        session.setAttribute("name", "admin");
		return "admin"; 

    }
    
}