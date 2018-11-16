package de.fhws.app.presentation.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.fhws.app.business.student.entity.ChangeLog;
import de.fhws.app.business.student.entity.Student;

@Stateless
public class Ejb1 {

	@PersistenceContext
	EntityManager em;

	@EJB
	Ejb2 ejb2;

	public void run1() {

		ejb2.run2();

		Student s = em.find(Student.class, 1l);
		ChangeLog cl = new ChangeLog();
		cl.setAction("ejb-test");
		s.getChangeLogs().add(cl);

		em.merge(s);

		throw new BusinessException("No Access allowed for the current uesr");

	}

}
