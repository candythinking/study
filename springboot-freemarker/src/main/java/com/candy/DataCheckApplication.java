package com.candy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DataCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataCheckApplication.class, args);
	}
}
