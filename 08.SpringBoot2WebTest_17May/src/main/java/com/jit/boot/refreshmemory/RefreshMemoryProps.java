package com.jit.boot.refreshmemory;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RefreshMemoryProps {
	
	@Scheduled(cron = "0 24 10 * * *")
	public void run() throws Exception {
		RestTemplate rt = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("{}", header);
		rt.exchange("http://192.168.0.7:8686/actuator/refresh", HttpMethod.POST, entity, String.class);
		System.out.println("DONE");
	}
}