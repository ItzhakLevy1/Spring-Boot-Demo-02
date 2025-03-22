package com.love2code.springfcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.love2code.springfcoredemo", "com.luv2code.util"}
)
public class SpringfcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringfcoredemoApplication.class, args);
	}
}