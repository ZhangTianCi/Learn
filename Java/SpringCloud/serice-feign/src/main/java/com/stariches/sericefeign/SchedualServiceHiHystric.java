package com.stariches.sericefeign;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
	@Override
	public HashMap sayHiFromClientOne(String name) {
		return new HashMap() {{
			put("state", false);
			put("errMsg", "Feign HystrixCommand");
			put("name", name);
			put("time", new Date());
		}};
	}
}
