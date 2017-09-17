package com.hrportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

@SpringBootApplication
public class ProjectApplication extends AsyncConfigurerSupport {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
}
