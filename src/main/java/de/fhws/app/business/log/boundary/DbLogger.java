package de.fhws.app.business.log.boundary;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.fhws.app.business.log.enitity.LogMessage;

@Stateless
public class DbLogger implements Logger {

	@PersistenceContext
	EntityManager em;

	public void log(LogMessage message) {
		em.persist(message);
	}
}
