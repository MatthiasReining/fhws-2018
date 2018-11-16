package de.fhws.app.business.student.boundary;

import java.util.List;

import javax.persistence.EntityManager;

import de.fhws.app.business.student.entity.Student;

public class StudentService {

	EntityManager em;

	public StudentService(EntityManager em) {
		this.em = em;
	}

	public List<Student> findAll() {
		return em.createNamedQuery(Student.FIND_ALL, Student.class).getResultList();
	}

}
