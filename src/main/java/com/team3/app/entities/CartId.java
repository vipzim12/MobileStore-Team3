package com.team3.app.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class CartId implements Serializable{

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
	private User user;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
	private Product product;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
