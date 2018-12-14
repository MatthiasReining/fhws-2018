package de.fhws.app.business.student.boundary;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.fhws.app.business.account.boundary.CurrentUser;
import de.fhws.app.business.account.entity.Account;
import de.fhws.app.business.student.entity.ChangeLog;
import de.fhws.app.business.student.entity.Student;

@Stateless
public class StudentService {

	@PersistenceContext
	EntityManager em;

	@Inject
	@CurrentUser
	Account currentUser;

	public List<Student> findAll() {
		return em.createNamedQuery(Student.FIND_ALL, Student.class).getResultList();
	}

	public Student find(long id) {
		return em.find(Student.class, id);
	}

	public Student save(Student currentStudent) {
		
		System.out.println(currentUser + " " + currentUser.getId());
		Account currentDBUser = em.find(Account.class, currentUser.getId());
		
		ChangeLog cl = new ChangeLog();
		cl.setAction(currentStudent.getId() == 0 ? "created" : "modified");
		cl.setModifiedTime(new Date());

		System.out.println("save");
		
		cl.setAccount(currentDBUser);

		currentStudent.getChangeLogs().add(cl);

		currentStudent = em.merge(currentStudent);
		return currentStudent;
	}

}
