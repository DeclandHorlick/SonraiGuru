package com.qa.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	public Transactions(String transType, double transAmount, Date date) {
		transactionType = transType;
		transactionAmount = transAmount;
		dateStamp = date;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	
	@Size(max = 1)
	private String transactionType;
	
	private double transactionAmount;
	
	@Type(type = "date")
	private Date dateStamp;
	
	public Long getTransactionId() {
		return transactionId;
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
	
	public String toString()
	{
		return transactionAmount + " " + dateStamp;
	}

}
