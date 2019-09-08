package com.virtusa.denorm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CompositePrimary.class)
public class CustomerDetail implements Serializable {
	@Id
	@GeneratedValue
	private int customerId;
	private String customerName;
	@Id
	private String customerEmail;
	private String customerPassword;
	private String customerDOB;
	private String customerAddress;
	private long customerContact;
	private String customerState;
	private String customerCity;

	public CustomerDetail(int customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}

	public CustomerDetail(int customerId) {
		super();
		this.customerId = customerId;
	}

	public CustomerDetail() {
		super();
	}

	@Override
	public String toString() {
		return "CustomerDetail [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPassword=" + customerPassword + ", customerDOB=" + customerDOB
				+ ", customerAddress=" + customerAddress + ", customerContact=" + customerContact + ", customerState="
				+ customerState + ", customerCity=" + customerCity + "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerDOB() {
		return customerDOB;
	}

	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public long getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(long customerContact) {
		this.customerContact = customerContact;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public CustomerDetail(String customerName, String customerEmail, String customerPassword, String customerDOB,
			String customerAddress, long customerContact, String customerState, String customerCity) {
		super();

		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerDOB = customerDOB;
		this.customerAddress = customerAddress;
		this.customerContact = customerContact;
		this.customerState = customerState;
		this.customerCity = customerCity;
	}

}
