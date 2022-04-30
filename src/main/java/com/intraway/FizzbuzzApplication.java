package com.intraway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = { "com.intraway.fizzbuzz.model" })
@EnableJpaRepositories(basePackages = {"com.intraway.fizzbuzz.dao"})
@ComponentScan(basePackages = {"com.intraway.fizzbuzz.controller", "com.intraway.fizzbuzz.dao", "com.intraway.fizzbuzz.service"})
@SpringBootApplication
public class FizzbuzzApplication {

	public static void main(String[] args) {
		SpringApplication.run(FizzbuzzApplication.class, args);
	}

}
