package com.quantrics.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.quantrics.demo")
public class TakeHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TakeHomeApplication.class, args);
	}

}
