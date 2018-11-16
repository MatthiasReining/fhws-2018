package de.fhws.app.presentation.student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.fhws.app.business.student.boundary.StudentService;
import de.fhws.app.business.student.entity.Student;

@SessionScoped
@Named
public class StudentListBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	EntityManager em;

	StudentService service;

	@PostConstruct
	void init() {
		System.out.println("in init; em=" + em);
		service = new StudentService(em);
	}

	private List<Student> students = new ArrayList<>();

	public void addStudent(Student student) {
		students.add(student);
	}

	public List<Student> getStudents() {
		return service.findAll();
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
