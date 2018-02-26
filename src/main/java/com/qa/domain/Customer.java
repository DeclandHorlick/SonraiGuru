package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Customer {

	
	public Customer() {}
	
	public Customer(String fName, String lName, String email) {
		firstName = fName;
		lastName = lName;
		this.email = email;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;	
	@Size(max = 20)
	private String firstName;
	@Size(max = 20)
	private String lastName;
	@Size(max = 100)
	private String email;
	
	public long getCustomerId() {
		return customerId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
}
