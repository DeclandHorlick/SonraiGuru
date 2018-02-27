package com.qa.integration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.qa.service.repository.TransactionInterface;

@Path("/transaction")
public class TransactionEndpoint {

	@Inject
	private TransactionInterface service;
	
	@GET
	@Path("/transactions")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllTransactions() {
		return service.getAllTransactions();
	}
	
	@POST
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createTransaction(String newTransaction) {
		return service.createTransaction(newTransaction);
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String findTransaction(@PathParam("id") Long transactionId) {
		return service.findTransaction(transactionId);
	}
	
	@GET
	@Path("/date")
	@Produces(MediaType.APPLICATION_JSON)
	public String findTransactionsBetweenDates(@QueryParam("fromDate") String fromDate, @QueryParam("toDate") String toDate) throws ParseException {
		return service.findTransactionsBetweenDates(fromDate, toDate);
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateTransaction(@PathParam("id") Long transactionId, String transaction) {
		return service.updateTransaction(transactionId, transaction);
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteTransaction(@PathParam("id") Long transactionId) {
		return service.deleteTransaction(transactionId);
	}
}
