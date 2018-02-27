package com.qa.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
public class Transactions {
	
	public Transactions() {}
	
	public Transactions(Long accId, String transType, double transAmount, Date date) {
		accountId = accId;
		transactionType = transType;
		transactionAmount = transAmount;
		dateStamp = date;
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	
	@ManyToOne(targetEntity = Account.class)
	@JoinColumn(referencedColumnName = "accountId")
	private Long accountId;
	
	@Size(max = 1)
	private String transactionType;
	
	private double transactionAmount;
	
	@Type(type = "date")
	private Date dateStamp;
	
	
	public Long getTransactionId() {
		return transactionId;
	}

	public Long getAccountId() {
		return accountId;
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
