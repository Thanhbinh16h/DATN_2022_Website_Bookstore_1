package com.poly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Datn2022WebsiteBookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(Datn2022WebsiteBookstoreApplication.class, args);
	}

}
