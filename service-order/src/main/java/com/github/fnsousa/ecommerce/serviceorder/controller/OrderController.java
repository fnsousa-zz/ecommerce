package com.github.fnsousa.ecommerce.serviceorder.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.fnsousa.ecommerce.serviceorder.dto.OrderRequestDTO;
import com.github.fnsousa.ecommerce.serviceorder.service.OrderService;

@RestController
@RequestMapping(path = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@PostMapping
	public ResponseEntity processOrder(@RequestBody @Valid OrderRequestDTO order) {
		service.processOrder(order);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
