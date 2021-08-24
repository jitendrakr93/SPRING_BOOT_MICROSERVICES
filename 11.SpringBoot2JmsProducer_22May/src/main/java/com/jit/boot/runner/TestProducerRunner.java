package com.jit.boot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jit.boot.model.CircInfo;
import com.jit.boot.producer.ProducerSevice;
import com.jit.boot.util.MessageConverter;

@Component
public class TestProducerRunner implements CommandLineRunner {

	@Autowired
	private ProducerSevice ps;

	@Override
	public void run(String... args) throws Exception {
		ps.send("my-q1",
				MessageConverter.convertCircInfo(new CircInfo("ABC15246", "ABC", "IND", 251, 252, "IND-WINNER")));
		System.out.println("SENT...");
	}

}
