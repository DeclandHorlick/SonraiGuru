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
	private Long customerId;	
	@Size(max = 20)
	private String firstName;
	@Size(max = 20)
	private String lastName;
	@Size(max = 100)
	private String email;
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
