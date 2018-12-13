package de.fhws.app.presentation.showcase.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.fhws.app.business.student.entity.ChangeLog;
import de.fhws.app.business.student.entity.Student;

@Stateless
public class Ejb2 {
	@PersistenceContext
	EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void run2() {

		Student s = em.find(Student.class, 2l);
		ChangeLog cl = new ChangeLog();
		cl.setAction("ejb2-test");
		s.getChangeLogs().add(cl);

		em.merge(s);
	}
}
