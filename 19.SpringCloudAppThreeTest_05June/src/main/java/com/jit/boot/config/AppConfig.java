package com.jit.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate rt() {
		return new RestTemplate();
	}
	
	@Bean
	public Sampler alwasySampler() {
		return Sampler.ALWAYS_SAMPLE; //TURN ON
		//return Sampler.NEVER_SAMPLE; //TURN OFF
	}
}
