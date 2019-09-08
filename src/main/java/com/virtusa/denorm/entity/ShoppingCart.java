package com.virtusa.denorm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;

import javax.persistence.OneToOne;

@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue
	private int cartId;

	@OneToOne
	@JoinColumn(name = "productId")
	private ProductDetail product;
	
	private int customerId;
	private String cartDate;

	public ShoppingCart() {

	}
	

	public ShoppingCart(int cartId, ProductDetail product, int customerId, String cartDate) {
		super();
		this.cartId = cartId;
		this.product = product;
		this.customerId = customerId;
		this.cartDate = cartDate;
	}


	public ShoppingCart(ProductDetail product, int customerId, String cartDate) {
		super();
		this.product = product;
		this.customerId = customerId;
		this.cartDate = cartDate;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public ProductDetail getProduct() {
		return product;
	}

	public void setProduct(ProductDetail product) {
		this.product = product;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCartDate() {
		return cartDate;
	}

	public void setCartDate(String cartDate) {
		this.cartDate = cartDate;
	}

}
