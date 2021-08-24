package com.jit.boot.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("PRODUCT-SERVICE")
public interface ProductRestConsumer {
	
	@GetMapping("/product/msg")
	public ResponseEntity<String> showData();
}
