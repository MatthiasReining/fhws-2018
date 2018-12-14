package de.fhws.app.business.log.boundary;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.fhws.app.business.log.enitity.LogMessage;

public class DbLogger implements Logger {

	@PersistenceContext
	EntityManager em;

	@PostConstruct
	void init() {
		System.out.println("DBLogger#init " + em);
	}

	public void log(LogMessage message) {
		em.persist(message);
	}
}
