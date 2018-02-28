package com.digital.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.digital.filter.MyFilter;

@Component  
public class UserServiceFallbackProvider implements ZuulFallbackProvider {  
  
	private static Logger log = LoggerFactory.getLogger(MyFilter.class);
    @Override  
    public String getRoute() {  
        return "service-rpc1";  
    }  
  
    @Override  
    public ClientHttpResponse fallbackResponse() {
    	log.info("日志service-rpc1不可用");
//    	System.out.println("service-rpc1不可用");
        return new ClientHttpResponse() {  
            @Override  
            public HttpStatus getStatusCode() throws IOException {  
                return HttpStatus.OK;  
            }  
  
            @Override  
            public int getRawStatusCode() throws IOException {  
                return this.getStatusCode().value();  
            }  
  
            @Override  
            public String getStatusText() throws IOException {  
                return this.getStatusCode().getReasonPhrase();  
            }  
  
            @Override  
            public void close() {  
  
            }  
  
            @Override  
            public InputStream getBody() throws IOException {  
                return new ByteArrayInputStream("service-rpc1不可用".getBytes());  
            }  
  
            @Override  
            public HttpHeaders getHeaders() {  
                HttpHeaders headers = new HttpHeaders();  
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));  
                headers.setContentType(mt);  
                return headers;  
            }  
        };  
    }  
}  
