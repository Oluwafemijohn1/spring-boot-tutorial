package com.ephemzy.springboot.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTutorialApplication {
	// To deploy the app

//	java -jar spring-boot-tutorial-1.0.0.jar --spring.profiles.active=prod

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutorialApplication.class, args);
	}

}
