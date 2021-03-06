package com.qa.service.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.domain.Account;
import com.qa.domain.Customer;
import com.qa.domain.Transactions;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class TransactionDBRepository implements TransactionInterface {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Transactional(REQUIRED)
	public String createTransaction(String transaction) {
		Transactions newTransaction = util.getObjectForJSON(transaction, Transactions.class);
		manager.persist(newTransaction);
		return "{\"message\": \"Transaction made\"}";
	}

	@Transactional(REQUIRED)
	public String deleteTransaction(Long id) {
		Transactions transaction = util.getObjectForJSON(findTransaction(id), Transactions.class);
		if(transaction != null) {
			manager.remove(transaction);
			return "{\"message\": \"Transaction removed\"}";
		}
		return "{\"message\": \"Transaction not found\"}";
	}

	
	public String findTransaction(Long id) {
		Transactions findTransaction = manager.find(Transactions.class, id);
		return util.getJSONForObject(findTransaction);
	}
	
	public String findTransactionsBetweenDates(String fromDate, String toDate) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFrom = null;
		Date dateTo = null;

		try {
			dateFrom = dateFormat.parse(fromDate);
			dateTo = dateFormat.parse(toDate);
			Logger log = Logger.getLogger(Account.class);
			log.info("------------" + dateFrom + "-----------------" + dateTo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Query query = manager.createQuery("SELECT t FROM Transactions t WHERE dateStamp BETWEEN  '"+fromDate+"' AND '"+toDate+"'");
		Collection<Transactions> list =  query.getResultList();
		System.out.println("SIZE IS "+list.size()+", "+dateFrom+", "+dateTo);
		return util.getJSONForObject(list);
	}
	
	// @Transactional(SUPPORTS)
	public String getAllTransactions() 
	{
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select t FROM Transactions t");
		Collection<Transactions> list =  query.getResultList();
		return util.getJSONForObject(list);
	} 
	
	@Transactional(REQUIRED)
	public String updateTransaction(Long id, String transactionToUpdate)
	{
		Transactions updatedTransaction = util.getObjectForJSON(transactionToUpdate, Transactions.class);
		Transactions currentTransaction = util.getObjectForJSON(findTransaction(id), Transactions.class);
		if (transactionToUpdate != null) 
		{
			currentTransaction.setTransactionType(updatedTransaction.getTransactionType());
			currentTransaction.setTransactionAmount(updatedTransaction.getTransactionAmount());
			manager.merge(currentTransaction);
		}
		return "{\"message\": \"transaction sucessfully updated\"}";
	}
	
}
