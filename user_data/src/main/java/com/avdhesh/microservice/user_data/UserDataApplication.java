package com.avdhesh.microservice.user_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableFeignClients
public class UserDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDataApplication.class, args);

		System.out.println("Service started sucessfully!");

	}
}
