package com.jit.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jit.boot.consumer.VendorRestConsumer;

@RestController
@RequestMapping("/order")
public class OrderRestController {

	@Autowired
	private VendorRestConsumer consumer; // HAS-A

	@GetMapping("/info")
	public String getOrderInfo() {
		return "FROM ORDER and " + consumer.getVendorData();
	}
}
