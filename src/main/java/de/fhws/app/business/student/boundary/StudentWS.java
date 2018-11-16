package de.fhws.app.business.student.boundary;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import de.fhws.app.business.student.entity.Student;

@WebService
@Stateless
public class StudentWS implements StudentWSRemote {

	@EJB
	StudentService studentService;


	@Override
	public Student getStudent(long id) {
		return studentService.find(id);
	}
}
