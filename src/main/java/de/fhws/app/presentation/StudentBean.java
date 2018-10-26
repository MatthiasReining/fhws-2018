package de.fhws.app.presentation;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.fhws.app.business.entity.Student;
import de.fhws.app.business.entity.Students;

@Named
@RequestScoped
public class StudentBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Student currentStudent = new Student();

	@Inject
	Students students;

	public String save() {
		System.out.println("save");
		System.out.println(currentStudent.getLastName());

		students.addStudent(currentStudent);

		return "student-list?faces-redirect=true";

	}

	public Student getCurrentStudent() {
		return currentStudent;
	}

	public void setCurrentStudent(Student currentStudent) {
		this.currentStudent = currentStudent;
	}

}
