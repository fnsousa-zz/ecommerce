package com.github.fnsousa.ecommerce.serviceemail.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.github.fnsousa.ecommerce.serviceemail.dto.OrderDTO;

@SpringBootApplication
@EnableKafka
@ComponentScan({ "com.github.fnsousa.ecommerce.serviceemail" })
@Configuration
public class ServiceEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceEmailApplication.class, args);
	}

	@Bean
	public ConsumerFactory<String, OrderDTO> consumerFactory(KafkaProperties kafkaProperties) {
		kafkaProperties.getProperties().put(JsonDeserializer.VALUE_DEFAULT_TYPE, OrderDTO.class.getName());
		return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
	}

}
