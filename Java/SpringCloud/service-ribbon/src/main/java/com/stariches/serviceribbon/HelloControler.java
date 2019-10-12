package com.stariches.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HelloControler {

	@Autowired
	HelloService helloService;

	@GetMapping(value = "/hi")
	public HashMap hi(@RequestParam String name) {
		return helloService.hiService(name);
	}
}