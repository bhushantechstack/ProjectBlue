package com.testing.projectblue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProjectblueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectblueApplication.class, args);
		System.out.println("Hello World");
	}

}
