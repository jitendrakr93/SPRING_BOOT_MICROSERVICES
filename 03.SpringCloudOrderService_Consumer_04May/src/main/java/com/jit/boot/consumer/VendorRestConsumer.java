package com.jit.boot.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VendorRestConsumer {

	//1. Autowire the LoadBalancerClient client
	@Autowired
	private LoadBalancerClient client;
	
	//define one operation for find/bind process
	public String getVendorData() {
		
		// goto eureka with ServiceId and get ServiceInstances
		ServiceInstance si = client.choose("VENDOR-SERVICE");
		
		//read URI and add Path
		String url = si.getUri() + "/vendor/msg";
		
		// use RestTemplate
		RestTemplate rt = new RestTemplate();
		
		//make call and get Response
		ResponseEntity<String>  resp = rt.getForEntity(url, String.class);
		
		//return response body
		return resp.getBody();
	}
	
}