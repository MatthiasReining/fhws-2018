package de.fhws.app.presentation.student;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.fhws.app.business.student.boundary.StudentService;
import de.fhws.app.business.student.entity.Student;

@SessionScoped
@Named
public class StudentListBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	StudentService service;

	public List<Student> getStudents() {
		return service.findAll();
	}

}
