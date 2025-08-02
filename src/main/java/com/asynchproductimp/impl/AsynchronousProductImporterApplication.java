package com.asynchproductimp.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsynchronousProductImporterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsynchronousProductImporterApplication.class, args);
	}

}
