package com.firstTrial.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Logger logger
				= Logger.getLogger(
				DemoApplication.class.getName());
		SpringApplication.run(DemoApplication.class, args);
	}

}
