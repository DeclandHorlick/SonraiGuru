package com.qa.service.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.domain.Transactions;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class TransactionDBRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Transactional(REQUIRED)
	public String createTransaction(String account) {
		Transactions transaction = util.getObjectForJSON(account, Transactions.class);
		manager.persist(transaction);
		return "{\"message\": \"Account made\"}";
	}

	@Transactional(REQUIRED)
	public String deleteTransaction(Long id) {
		Transactions transaction = findTransaction(id);
		if(transaction != null) {
			manager.remove(transaction);
			return "{\"message\": \"Account removed\"}";
		}
		return "{\"message\": \"Account not found\"}";
	}

	
	public Transactions findTransaction(Long id) {
		return manager.find(Transactions.class, id);
	}
	
	@Transactional(SUPPORTS)
	public String getAllAccounts() 
	{
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select a FROM Account a");
		Collection<Transactions> list =  query.getResultList();
		return util.getJSONForObject(list);
	} 
	
	@Transactional(REQUIRED)
	public String updateTransaction(Long accountNumber, String accountToUpdate)
	{
		Transactions updatedTransaction = util.getObjectForJSON(accountToUpdate, Transactions.class);
		Transactions currentTransaction = findTransaction(accountNumber);
		if (accountToUpdate != null) 
		{
			currentTransaction.setTransactionType(updatedTransaction.getTransactionType());
			currentTransaction.setTransactionAmount(updatedTransaction.getTransactionAmount());
			
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}
	
}
