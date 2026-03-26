package com.institute.skill8;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.institute.skill8.entity.Product;
import com.institute.skill8.repository.ProductRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Skill8Application {

	public static void main(String[] args) {
		SpringApplication.run(Skill8Application.class, args);
	}
	@Bean
	CommandLineRunner run(ProductRepository repo) {
	    return args -> {
	        repo.save(new Product("Laptop", "Electronics", 50000));
	        repo.save(new Product("Phone", "Electronics", 20000));
	        repo.save(new Product("Shoes", "Fashion", 3000));
	        repo.save(new Product("Watch", "Fashion", 5000));
	    };
	}

}
