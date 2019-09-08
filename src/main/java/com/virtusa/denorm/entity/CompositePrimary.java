package com.virtusa.denorm.entity;

import java.io.Serializable;

public class CompositePrimary implements Serializable {
	    protected Integer customerId;
	    protected String customerEmail;

	    public CompositePrimary() {}

	    public CompositePrimary(Integer customerId, String customerEmail) {
	        this.customerId = customerId;
	        this.customerEmail = customerEmail;
	    }
	    // equals, hashCode
	
}
