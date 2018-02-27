package com.qa.service.repository;

import java.util.Date;

public interface TransactionInterface {
	
	String createTransaction(String transaction);
	
	String getAllTransactions();
	
	String findTransaction(Long id);

	String updateTransaction(Long id, String customerToUpdate);

	String deleteTransaction(Long id);
	
	String findTransactionsBetweenDates(String fromDate, String toDate);
}
