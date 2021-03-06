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

import com.qa.service.repository.AccountInterface;
import com.qa.service.repository.CustomerInterface;

@Path("/account")
public class AccountEndpoint {
	
	@Inject
	private AccountInterface service;
	
	@GET
	@Path("/accounts")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAccounts() {
		return service.getAllAccounts();
	}
	
	@POST
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createAccount(String newAccount) {
		return service.createAccount(newAccount);
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String findAccount(@PathParam("id") Long accountId) {
		return service.findAccount(accountId);
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateAccount(@PathParam("id") Long accountId, String account) {
		return service.updateAccount(accountId, account);
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteAccount(@PathParam("id") Long accountId) {
		return service.deleteAccount(accountId);
	}
}
