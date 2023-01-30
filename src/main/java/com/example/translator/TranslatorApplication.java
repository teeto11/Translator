package com.example.translator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class TranslatorApplication {

	public static void main(String[] args) {
//		System.setProperty("spring.profiles.active","dev");
		SpringApplication.run(TranslatorApplication.class, args);
	}

}
