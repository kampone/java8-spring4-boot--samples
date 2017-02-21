package com.notemates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//It's a sample where I try to user new Future interface(CompletableFuture) like a return type in Spring Boot

@SpringBootApplication
public class CompletableFutureApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompletableFutureApplication.class, args);
	}
}
