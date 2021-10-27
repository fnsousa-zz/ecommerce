package com.github.fnsousa.ecommerce.serviceorder.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
@ComponentScan({"com.github.fnsousa.ecommerce.serviceorder"})
@EnableJpaRepositories("com.github.fnsousa.ecommerce.serviceorder.repository")
@EntityScan("com.github.fnsousa.ecommerce.serviceorder.model")
public class ServiceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceOrderApplication.class, args);
	}

}
