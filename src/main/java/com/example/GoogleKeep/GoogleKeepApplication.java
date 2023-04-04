package com.example.GoogleKeep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoogleKeepApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(GoogleKeepApplication.class, args);
		}
		catch (Exception exception){
			System.out.println(exception.getMessage());
		}
	}
}
