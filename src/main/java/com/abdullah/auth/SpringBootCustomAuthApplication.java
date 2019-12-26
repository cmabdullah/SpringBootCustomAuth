package com.abdullah.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@EnableCaching
@SpringBootApplication
public class SpringBootCustomAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCustomAuthApplication.class, args);
	}

}
