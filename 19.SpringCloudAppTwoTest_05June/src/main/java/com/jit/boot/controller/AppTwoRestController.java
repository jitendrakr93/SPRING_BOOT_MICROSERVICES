package com.jit.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppTwoRestController {

	private static final Logger LOG = LoggerFactory.getLogger(AppTwoRestController.class);
	
	@Autowired
	private RestTemplate rt;
	
	@GetMapping("/showB")
	public String showB() {
		LOG.info("WELCOME TO SERVICE #2 ");
		String msg  = rt.getForObject("http://localhost:8083/showC", String.class);
		LOG.info("BACK TO SERVICE #2 : MSG {}", msg);
		return "FROM SERVICE#2 => got => " + msg;
	}
	
}
