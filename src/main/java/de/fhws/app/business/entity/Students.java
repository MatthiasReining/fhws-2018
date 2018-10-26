package de.fhws.app.business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class Students implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Student> students = new ArrayList<>();

	public void addStudent(Student student) {
		students.add(student);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
