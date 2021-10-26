package com.github.fnsousa.ecommerce.serviceorder.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
	
	@NotNull(message = "{emptyCart}")
	private List<ProductOrderDTO> products;

}
