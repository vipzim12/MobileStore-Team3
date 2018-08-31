package com.team3.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Carts")
public class Cart implements Serializable{

	@EmbeddedId
	private CartId cartId;
	
	@Column(name="quantity")
	private int quantity;
	
	
	public CartId getCartId() {
		return cartId;
	}
	public void setCartId(CartId cartId) {
		this.cartId = cartId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	

	
	
	
}
