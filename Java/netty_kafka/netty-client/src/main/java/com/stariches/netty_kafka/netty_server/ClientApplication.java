package com.stariches.netty_kafka.netty_server;

import org.springframework.web.bind.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import java.util.Date;
import java.util.HashMap;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ClientApplication {


    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @ResponseBody
    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public HashMap home(@RequestParam(value = "message", required = false, defaultValue = "null") String message) {

        return new HashMap() {{
            put("port", port);
            put("state", true);
            put("name", message);
            put("time", new Date());
            put("errMsg", "success");
        }};
    }

    public HashMap hiError(String name) {
        return new HashMap() {{
            put("port", port);
            put("state", false);
            put("name", name);
            put("time", new Date());
            put("errMsg", "HystrixCommand");
        }};
    }

}

