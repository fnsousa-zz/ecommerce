package com.github.fnsousa.ecommerce.serviceorder.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.github.fnsousa.ecommerce.serviceorder.dto.ProductOrderDTO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name =  "tb_order")
@SequenceGenerator(name = "seq_order", sequenceName = "seq_order", allocationSize = 1, initialValue = 1)
@Getter
@Setter
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_order")
	private Long id;
	
	@OneToMany(mappedBy = "id.order", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<ProductOrder> products = new ArrayList<>();
	
	@Column(name = "id_user")
	private Long idUser;
	
	public void addProduct(ProductOrderDTO productOrderDTO) {
		ProductOrder productOrder = new ProductOrder();
		productOrder.setId(new IdProductOrder());
		
		productOrder.getId().setOrder(this);
		productOrder.getId().setIdProduct(productOrderDTO.getIdProduct());
		productOrder.setAmmount(productOrderDTO.getAmmount());
		
		this.products.add(productOrder);
	}
	
	public void addProduct(List<ProductOrderDTO> productsOrderDTO) {
		productsOrderDTO.forEach(this::addProduct);
	}
	

}
