package com.jit.boot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
public class VendorRestController {

	@GetMapping("/msg")
	public ResponseEntity<String> showVenMsg(){
		return ResponseEntity.ok("FROM VENDOR");
	}
}
