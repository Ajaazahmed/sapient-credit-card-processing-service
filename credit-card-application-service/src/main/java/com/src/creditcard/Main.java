package com.src.creditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.src.creditcard"})
@EntityScan("com.src.creditcard.jpa.entity")
@EnableJpaRepositories("com.src.creditcard.repository")
@EnableAutoConfiguration
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
