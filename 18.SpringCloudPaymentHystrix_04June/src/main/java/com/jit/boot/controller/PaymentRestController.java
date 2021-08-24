package com.jit.boot.controller;

import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {
	@GetMapping("/pay")
	@HystrixCommand(fallbackMethod = "doPaymentFallback", commandKey = "paymentFallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000") })
	public String doPayment() {
		System.out.println("FROM ACTUAL METHOD");
		if (new Random().nextInt(80) < 50) {
			throw new RuntimeException("FROM DUMMY EXCEPTION!");
		}
		return "SUCCESS!!";
	}

	public String doPaymentFallback() {
		System.out.println("FROM FALLBACK METHOD");
		return "FAILED! TRY AFTER SOME TIME!!";
	}
}