package de.fhws.app.business.account.boundary;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import de.fhws.app.business.account.control.NoDataException;

@Provider
public class NoDataExceptionMapper implements ExceptionMapper<NoDataException> {

	@Override
	public Response toResponse(NoDataException exception) {
		return Response
				.status(Status.OK)
				.entity("{\"cause\":\"no-data\",\"entity\":\""+exception.getMessage()+"\"}")
				.build();
	}

}
