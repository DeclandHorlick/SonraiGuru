package com.qa.service.repository;

public interface CustomerInterface {

	String createCustomer(String newCustomer);
	
	String getAllCustomers();
	
	String findCustomer(Long id);

	String updateCustomer(Long id, String customerToUpdate);

	String deleteCustomer(Long id);
}
