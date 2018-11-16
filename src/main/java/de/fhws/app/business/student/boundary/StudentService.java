package de.fhws.app.business.student.boundary;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.fhws.app.business.student.entity.ChangeLog;
import de.fhws.app.business.student.entity.Student;

@Stateless
public class StudentService {

	@PersistenceContext
	EntityManager em;

	public List<Student> findAll() {
		return em.createNamedQuery(Student.FIND_ALL, Student.class).getResultList();
	}

	public Student find(long id) {
		return em.find(Student.class, id);
	}

	public Student save(Student currentStudent) {
		ChangeLog cl = new ChangeLog();
		cl.setAction(currentStudent.getId() == 0 ? "created" : "modified");
		cl.setModifiedTime(new Date());

		currentStudent.getChangeLogs().add(cl);

		currentStudent = em.merge(currentStudent);
		return currentStudent;
	}

}
