package com.digital.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.digital.api.RpcServerService;
import com.digital.entity.UserEntity;



@Component
public class RpcServerServiceError implements RpcServerService {

	@Override
	public String userAction(String name,UserEntity ue) {
		// TODO Auto-generated method stub
		return "sorry error"+name;
	}

}
