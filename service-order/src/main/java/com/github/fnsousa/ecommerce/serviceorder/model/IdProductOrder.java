package com.github.fnsousa.ecommerce.serviceorder.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class IdProductOrder implements Serializable {

	private static final long serialVersionUID = -8205003326518421545L;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	@Column(name = "id_product")
	private Long idProduct;
	
}
