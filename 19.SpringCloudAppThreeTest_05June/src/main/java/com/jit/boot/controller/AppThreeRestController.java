package com.jit.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppThreeRestController {

	private static final Logger LOG = LoggerFactory.getLogger(AppThreeRestController.class);
	
	@GetMapping("/showC")
	public String showC() {
		LOG.info("WELCOME TO SERVICE #3 ");
		LOG.info("LEAVING SERVICE #3 ");
		return "FROM SERVICE#3";
	}
	
}
