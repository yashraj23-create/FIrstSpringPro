package com.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "TripMate Project Rest Apis",
				description = "RestApis testing for TripMate",
				version = "v1",
				contact = @Contact(
						name = "Yashraj",
						email = "fs23if023@gmail.com"
				)
		)
)

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}
}
