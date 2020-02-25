package com.rest.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.source.service.RestCallService;

@SpringBootApplication
public class SourceApplication implements CommandLineRunner {
	@Autowired
	private RestCallService restCallService;

	public static void main(String[] args) {
		SpringApplication.run(SourceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restCallService.getService();
	}

}
