package de.fhws.app.business.student.boundary;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import de.fhws.app.business.student.entity.Student;

public class StudentService {

	EntityManager em;
	UserTransaction tx;

	public StudentService(EntityManager em) {
		this.em = em;
	}

	public StudentService(EntityManager em, UserTransaction tx) {
		this.em = em;
		this.tx = tx;
	}

	public List<Student> findAll() {
		return em.createNamedQuery(Student.FIND_ALL, Student.class).getResultList();
	}

	public Student find(long id) {
		return em.find(Student.class, id);
	}

	public Student save(Student currentStudent) {
		try {
			tx.begin();
			currentStudent = em.merge(currentStudent);
			tx.commit();
			return currentStudent;
		} catch (NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			throw new RuntimeException(e);
		}
	}

}
