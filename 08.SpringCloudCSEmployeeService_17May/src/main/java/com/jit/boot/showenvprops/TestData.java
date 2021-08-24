package com.jit.boot.showenvprops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class TestData implements CommandLineRunner {
	@Autowired
	private Environment env;

	public void run(String... args) throws Exception {
		System.out.println(env.getClass());
		System.out.println(env.getProperty("my.app.title"));
	}
}
