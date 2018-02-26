package com.qa.service.repository;

public interface AccountInterface {
	
	String createAccount(String newAccount);
	
	String getAllAccounts();
	
	String findAccount(Long id);

	String updateAccount(Long id, String accountToUpdate);

	String deleteAccount(Long id);
}
