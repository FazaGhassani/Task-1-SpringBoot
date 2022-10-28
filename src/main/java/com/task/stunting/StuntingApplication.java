package com.task.stunting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class StuntingApplication {

	public static void main(String[] args) {
		SpringApplication.run(StuntingApplication.class, args);
	}

}
