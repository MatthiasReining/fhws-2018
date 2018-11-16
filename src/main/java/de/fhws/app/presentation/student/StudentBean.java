package de.fhws.app.presentation.student;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import de.fhws.app.business.student.entity.Student;

@Named
@RequestScoped
public class StudentBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Student currentStudent = new Student();

	@Inject
	StudentListBean students;
	
	@PersistenceContext
	EntityManager em;
	
	@Resource
	UserTransaction tx;

	public String save() {
		
		try {
			tx.begin();
			em.persist(currentStudent);
			tx.commit();
		} catch (NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
			throw new RuntimeException(e);
		}
		
		
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
