package de.fhws.app.presentation.student;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import de.fhws.app.business.student.boundary.StudentService;
import de.fhws.app.business.student.entity.Student;

@Named
@SessionScoped
public class StudentBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Student currentStudent = new Student();

	StudentService service;

	@PersistenceContext
	EntityManager em;

	@Resource
	UserTransaction tx;

	@PostConstruct
	void init() {
		service = new StudentService(em, tx);
	}

	public String load(long id) {
		currentStudent = service.find(id);
		return "student";
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
