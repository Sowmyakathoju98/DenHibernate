package com.virtusa.denorm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransactionDetail {

	@Id
	private int transactionId;
	private OrderDetail transactionOrder;
	private Date transactionDate;
	private CustomerDetail customer;
	private ProductDetail product;
	private int status;
	private float orderTotalAmount;

	@Override
	public String toString() {
		return "TransactionDetail [transactionId=" + transactionId + ", transactionOrder=" + transactionOrder
				+ ", transactionDate=" + transactionDate + ", customer=" + customer + ", product=" + product
				+ ", status=" + status + ", orderTotalAmount=" + orderTotalAmount + "]";
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public OrderDetail getTransactionOrder() {
		return transactionOrder;
	}

	public void setTransactionOrder(OrderDetail transactionOrder) {
		this.transactionOrder = transactionOrder;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public float getOrderTotalAmount() {
		return orderTotalAmount;
	}

	public void setOrderTotalAmount(float orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}

	public TransactionDetail() {
		// TODO Auto-generated constructor stub
	}

}
