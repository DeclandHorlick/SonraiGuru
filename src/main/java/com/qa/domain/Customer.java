package com.qa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Customer {

	public Customer() {}
	
	public Customer(String fName, String lName, String email, Set<Account> accounts) {
		firstName = fName;
		lastName = lName;
		this.email = email;
		accountIds = accounts;
		
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Account> accountIds = new HashSet<Account>();
	
	@Size(max = 20)
	private String firstName;
	@Size(max = 20)
	private String lastName;
	@Size(max = 100)
	private String email;
	
	public Set<Account> getCustomerId() {
		return accountIds;
	}

	public void setCustomerId(Set<Account> customerId) {
		this.accountIds = customerId;
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
