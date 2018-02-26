package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Account {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	
	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "CUST_ID", referencedColumnName = "customerId")	
	private Long customerId;
	
	@Size(max = 10)
	private String accountNumber;
	
	@Size(max = 1)
	private String accountType;
	
	public Account() {
		
	}
	
	public Account(Long custId, String accNo, String accType) {
		customerId = custId;
		accountNumber = accNo;
		accountType = accType;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
}
