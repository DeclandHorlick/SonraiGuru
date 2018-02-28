package com.qa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;

@Entity
public class Account {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Transactions> transactionIds = new HashSet<Transactions>();
	
	@Size(max = 10)
	private String accountNumber;
	
	@Size(max = 1)
	private String accountType;
	
	public Account() {
		
	}
	
	public Account(String accNo, String accType) {
		Logger log = Logger.getLogger(Account.class);
		// log.info("------------" + t);
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

//	public void setCustomerId(Long customerId) {
//		this.customerId = customerId;
//	}
	
}
