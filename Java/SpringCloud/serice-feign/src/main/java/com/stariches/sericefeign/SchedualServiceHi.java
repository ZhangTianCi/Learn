package com.stariches.sericefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	HashMap sayHiFromClientOne(@RequestParam(value = "name") String name);
}
