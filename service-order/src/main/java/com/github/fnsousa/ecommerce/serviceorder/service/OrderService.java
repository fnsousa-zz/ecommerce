package com.github.fnsousa.ecommerce.serviceorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.github.fnsousa.ecommerce.serviceorder.dto.OrderDTO;
import com.github.fnsousa.ecommerce.serviceorder.dto.OrderRequestDTO;
import com.github.fnsousa.ecommerce.serviceorder.model.Order;
import com.github.fnsousa.ecommerce.serviceorder.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
    private KafkaTemplate<String, OrderDTO> kafkaTemplate;
	
	public void processOrder(OrderRequestDTO orderRequestDTO) {
		
		Order order = new Order();
		order.setIdUser(123L);
		order.addProduct(orderRequestDTO.getProducts());
		repository.save(order);
		
		OrderDTO orderDTO = new  OrderDTO();
		orderDTO.setProducts(orderRequestDTO.getProducts());
		orderDTO.setId(order.getId());
		
		this.kafkaTemplate.send("ECOMMERCE_NEW_ORDER", orderDTO);
		
	}

}
