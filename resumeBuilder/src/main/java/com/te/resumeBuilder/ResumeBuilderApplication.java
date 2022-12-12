package com.te.resumeBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition 	/*localhost:9191/swagger-ui/index.html */
public class ResumeBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeBuilderApplication.class, args);
	}
}

