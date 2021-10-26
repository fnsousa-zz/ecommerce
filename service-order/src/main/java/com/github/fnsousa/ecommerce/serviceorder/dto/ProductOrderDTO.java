package com.github.fnsousa.ecommerce.serviceorder.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderDTO {
	
	@NotNull
	private Long idProduct;
	@NotNull
	private Long ammount;

}
