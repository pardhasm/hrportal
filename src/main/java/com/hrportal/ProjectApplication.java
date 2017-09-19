package com.hrportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Import(RepositoryRestMvcAutoConfiguration.class)
@SpringBootApplication
@ComponentScan(basePackages = "com.hrportal")
@EnableWebMvc
public class ProjectApplication extends AsyncConfigurerSupport {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
}
