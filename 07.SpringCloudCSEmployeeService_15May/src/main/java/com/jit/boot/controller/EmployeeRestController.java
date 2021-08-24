package com.jit.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/emp")
public class EmployeeRestController {
	
	@Value("${my.name}")
	private String code;

	@GetMapping("/msg")
	public String showData() {
		return "Hello FROM MS# " + code;
	}
}