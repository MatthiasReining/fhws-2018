package de.fhws.app.business.student.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.fhws.app.business.student.entity.Student;

@Path("students")
public class StudentResource {

	@Inject
	StudentService service;
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("id") Long id) {
		return service.find(id);
		
	}
}
