package com.jit.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppOneRestController {

	private static final Logger LOG = LoggerFactory.getLogger(AppOneRestController.class);
	
	@Autowired
	private RestTemplate rt;
	
	@GetMapping("/showA")
	public String showA() {
		LOG.info("WELCOME TO SERVICE #1 ");
		String msg  = rt.getForObject("http://localhost:8082/showB", String.class);
		LOG.info("BACK TO SERVICE #1 : MSG {}", msg);
		return "DONE FROM SERVICE#1 => Got => " + msg;
	}
	
}
