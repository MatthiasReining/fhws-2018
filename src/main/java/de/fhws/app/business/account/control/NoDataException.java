package de.fhws.app.business.account.control;

import javax.ejb.ApplicationException;
import javax.ws.rs.WebApplicationException;

@ApplicationException(rollback = true)
public class NoDataException extends WebApplicationException {

	private static final long serialVersionUID = 1L;


	public NoDataException(String entity) {
		super(entity);
	}
}
