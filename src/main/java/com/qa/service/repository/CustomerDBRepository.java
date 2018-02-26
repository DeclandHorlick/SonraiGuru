package com.qa.service.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.domain.Customer;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class CustomerDBRepository implements CustomerInterface {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Transactional(REQUIRED)
	@Override
	public String createCustomer(String customer) {
		Customer newCustomer = util.getObjectForJSON(customer, Customer.class);
		manager.persist(newCustomer);
		return "{\"message\": \"customer has been sucessfully added\"}";
	}

	@Override
	public String getAllCustomers() {
		Query query = manager.createQuery("Select c FROM Customer c");
		Collection<Customer> customers = (Collection<Customer>) query.getResultList();
		return util.getJSONForObject(customers);
	}

	@Override
	public String findCustomer(Long id) {
		Customer findCustomer = manager.find(Customer.class, id);
		return util.getJSONForObject(findCustomer);
	}

	@Transactional(REQUIRED)
	@Override
	public String updateCustomer(Long id, String customerToUpdate) {
		Customer updatedCustomer = util.getObjectForJSON(customerToUpdate, Customer.class);
		Customer customerFromDB = util.getObjectForJSON(findCustomer(id), Customer.class);
		if (customerToUpdate != null) {
			customerFromDB.setFirstName(updatedCustomer.getFirstName());
			customerFromDB.setLastName(updatedCustomer.getLastName());
			customerFromDB.setEmail(updatedCustomer.getEmail());
			manager.merge(customerFromDB);
		}
		return "{\"message\": \"customer sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	@Override
	public String deleteCustomer(Long id) {
		Customer customerInDB = util.getObjectForJSON(findCustomer(id), Customer.class);
		if (customerInDB != null) {
			manager.remove(manager.contains(customerInDB) ? customerInDB : manager.merge(customerInDB));
			return "{\"message\": \"customer sucessfully deleted\"}";
		}
		return "{\"message\": \"customer not found\"}";
	}

}
