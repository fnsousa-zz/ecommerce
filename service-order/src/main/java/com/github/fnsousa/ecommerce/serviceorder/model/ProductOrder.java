package com.github.fnsousa.ecommerce.serviceorder.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_product_order")
@Getter
@Setter
public class ProductOrder {
	
	@EmbeddedId
	private IdProductOrder id;
	@Column(name = "ammount")
	private Long ammount;
	
	
}
