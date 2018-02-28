package com.digital.turbine;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
@EnableHystrixDashboard
public class ServiceTurbineApplication {

    public static void main(String[] args) {

            new SpringApplicationBuilder(ServiceTurbineApplication.class).web(true).run(args);
    }
}
