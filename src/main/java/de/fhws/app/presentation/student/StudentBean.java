package de.fhws.app.presentation.student;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.fhws.app.business.student.boundary.StudentService;
import de.fhws.app.business.student.entity.Student;

@Named
@SessionScoped
public class StudentBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Student currentStudent = new Student();

	@EJB
	StudentService service;
	
	public String initNewStudent() {
		currentStudent = new Student();
		return "student";
	}

	public String load(long id) {
		currentStudent = service.find(id);
		return "student?faces-redirect=true";
	}

	public String save() {
		currentStudent = service.save(currentStudent);
		return "student-list?faces-redirect=true";

	}

	public Student getCurrentStudent() {
		return currentStudent;
	}

	public void setCurrentStudent(Student currentStudent) {
		this.currentStudent = currentStudent;
	}

}
