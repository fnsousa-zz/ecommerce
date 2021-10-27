package com.github.fnsousa.ecommerce.serviceemail.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
	
	private Long id;
	private List<ProductOrderDTO> products;

}
