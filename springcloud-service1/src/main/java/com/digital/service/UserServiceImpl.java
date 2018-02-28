package com.digital.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.digital.api.UserService;
import com.digital.dao.UserDao;
import com.digital.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    UserDao userdao;

    @Value("${server.port}")
    String port;
	public String query(String name) {
		// TODO Auto-generated method stub
		List list=userdao.query(name);
		String user=userdao.query(name).get(0).getUser();
		return user+" i am from port:" +port;
	}
	
}
