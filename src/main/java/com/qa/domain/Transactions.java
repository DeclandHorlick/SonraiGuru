package com.qa.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Transactions {
	
	public Transactions() {}
	
	public Transactions(long accId, String transType, double transAmount, Date date) {
		accountId = accId;
		transactionType = transType;
		transactionAmount = transAmount;
		dateStamp = date;
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	
	@ManyToOne(targetEntity = Account.class)
	@JoinColumn(referencedColumnName = "accountId")
	private long accountId;
	
	@Size(max = 1)
	private String transactionType;
	
	private double transactionAmount;
	
	private Date dateStamp;
	
	
	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getDateStamp() {
		return dateStamp;
	}

	public void setDateStamp(Date dateStamp) {
		this.dateStamp = dateStamp;
	}

}