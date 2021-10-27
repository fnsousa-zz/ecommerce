package com.github.fnsousa.ecommerce.serviceemail.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.github.fnsousa.ecommerce.serviceemail.dto.OrderDTO;


@Component
public class SendEmail {

	@Autowired
	private JavaMailSender emailSender;

	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("noreply@felipe.com");
		message.setTo("felipe_nsousa@outlook.com");
		message.setSubject("Teste Email Local");
		message.setText("Conteúdo do email");
		emailSender.send(message);
	}

	@KafkaListener(topics = "ECOMMERCE_NEW_ORDER", groupId = "service-email")
	public void consume(ConsumerRecord<String, OrderDTO> payload) {
		System.out.println("Order: {}" + payload.value());
		sendSimpleMessage("", "", "");

	}

}
