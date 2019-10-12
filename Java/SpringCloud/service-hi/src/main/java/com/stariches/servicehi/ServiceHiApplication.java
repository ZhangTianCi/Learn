package com.stariches.servicehi;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ServiceHiApplication {

	/**
	 * 访问地址 http://localhost:8762/actuator/hystrix.stream
	 *
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@ResponseBody
	@RequestMapping("/hi")
	@HystrixCommand(fallbackMethod = "hiError")
	public HashMap home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
		return new HashMap() {{
			put("state", true);
			put("errMsg", "success");
			put("name", name);
			put("port", port);
			put("time", new Date());
		}};
	}

	public HashMap hiError(String name) {
		return new HashMap() {{
			put("state", false);
			put("errMsg", "HystrixCommand");
			put("name", name);
			put("port", port);
			put("time", new Date());
		}};
	}

}

