package de.fhws.app.business.account.control;

import javax.ws.rs.WebApplicationException;

public class NoDataException extends WebApplicationException {

	private static final long serialVersionUID = 1L;


	public NoDataException(String entity) {
		super(entity);
	}
}
