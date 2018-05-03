package com.digital.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession  
public class HttpSessionConfig {  
//    @Bean  
//    public JedisConnectionFactory connectionFactory() {  
//            return new JedisConnectionFactory();  
//    }  

	
//这里这个如果要使用配置文件里的redis配置就要去除，直接用@EnableRedisHttpSession标签和@Configuration标签即可
//如果使用默认的jedis的配置就可以添加，jedis默认配置是localhost:8769
}  
