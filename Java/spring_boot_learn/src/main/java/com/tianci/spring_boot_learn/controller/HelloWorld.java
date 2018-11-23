package com.tianci.spring_boot_learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/Hello")
public class HelloWorld {

	@ResponseBody
	@RequestMapping(value = "Json", method = RequestMethod.GET)
	public Object Json() {
		return new HashMap() {{
			put("errCode", 0);
			put("msg", "Success");
		}};
	}

	@ResponseBody
	@RequestMapping(value = "Json/Post", method = RequestMethod.POST)
	public Object BaseJson_Post() {
		return new HashMap() {{
			put("errCode", 0);
			put("msg", "Success");
		}};
	}
 	@RequestMapping(value = "Page", method = RequestMethod.GET)
	public ModelAndView BaseJson_Web() {
		return new ModelAndView("Hello/index", new HashMap() {{
			put("errCode", 0);
			put("msg", "Success");
		}});
	}
}
