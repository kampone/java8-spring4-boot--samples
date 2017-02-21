package com.notemates.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompleatableFutureController {

	@RequestMapping("/future")
	public CompletableFuture<String> run(){
		return CompletableFuture.completedFuture("Hello from future response").thenApply(it -> {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return it.toUpperCase();
		});
	}


	@RequestMapping("/past")
	public String past(){
		return "Hello from past response".toUpperCase();
	}

	
}
