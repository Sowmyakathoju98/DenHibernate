package com.virtusa.denorm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderDetail {

	@Id
	private int orderId;
	private CustomerDetail customer;
	private ProductDetail product;
	private int orderQuantity;
	private float orderTotalAmount;
	private int orderStatus;
	
	
	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public CustomerDetail getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerDetail customer) {
		this.customer = customer;
	}


	public ProductDetail getProduct() {
		return product;
	}


	public void setProduct(ProductDetail product) {
		this.product = product;
	}


	public int getOrderQuantity() {
		return orderQuantity;
	}


	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}


	public float getOrderTotalAmount() {
		return orderTotalAmount;
	}


	public void setOrderTotalAmount(float orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}


	public int getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}


	@Override
	public String toString() {
		return "OrderDetail [orderId=" + orderId + ", customer=" + customer + ", product=" + product
				+ ", orderQuantity=" + orderQuantity + ", orderTotalAmount=" + orderTotalAmount + ", orderStatus="
				+ orderStatus + "]";
	}


	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

}
