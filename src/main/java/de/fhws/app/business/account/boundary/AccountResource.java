package de.fhws.app.business.account.boundary;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import de.fhws.app.business.account.entity.Account;

@Path("accounts")
public class AccountResource {

	@Inject
	AccountService as;

		
	
	@GET
	public List<Account> getAccounts(@QueryParam("prefix") String prefix) {
		System.out.println("filter");
		List<Account> all = as.getAccounts();
		if (prefix == null)
			return all;
		
		return all.stream()
				.filter(a -> a.getUsername().startsWith(prefix))
				.collect(Collectors.toList());	
	}

	@GET
	@Path("{username}")
	public Account getUser(@PathParam("username") String username) {
		System.out.println("username: " + username);
		return as.getAccount(username);
	}
	
	@POST
	public Account update(Account account) {
		return as.createOrUpdate(account);
	}
}
