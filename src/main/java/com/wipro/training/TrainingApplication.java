package com.wipro.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TrainingApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}

}
