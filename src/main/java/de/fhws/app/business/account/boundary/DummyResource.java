package de.fhws.app.business.account.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.fhws.app.business.account.entity.AccountDummy;

@Path("fhws-dummy")
public class DummyResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public AccountDummy getAccounts() {
		AccountDummy account = new AccountDummy("FHWS", "Java EE");
		return account;
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public AccountDummy getAccountsXML() {
		AccountDummy account = new AccountDummy("FHWS for XML", "Java EE");
		return account;
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getAccountsFHWSProtocol() {
		return "<h1>Hallo FHWS</h1>";
	}

	@GET
	@Path("test")
	public Response test() {
		return Response.status(202).header("blub", "test").entity("test").build();
	}
}
