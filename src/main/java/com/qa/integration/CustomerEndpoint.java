package com.qa.integration;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qa.service.repository.CustomerInterface;

@Path("/customer")
public class CustomerEndpoint {

	@Inject
	private CustomerInterface service;
	
	@GET
	@Path("/customers")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllCustomers() {
		return service.getAllCustomers();
	}
	
	@POST
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createCustomer(String customer) {
		return service.createCustomer(customer);
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String findCustomer(@PathParam("id") Long customerId) {
		return service.findCustomer(customerId);
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateCustomer(@PathParam("id") Long customerId, String customer) {
		return service.updateCustomer(customerId, customer);
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteAccount(@PathParam("id") Long customerId) {
		return service.deleteCustomer(customerId);
	}
	
}
