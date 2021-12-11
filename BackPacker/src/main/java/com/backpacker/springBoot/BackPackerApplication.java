package com.backpacker.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.backpacker"}) 
public class BackPackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackPackerApplication.class, args);
	}

}
