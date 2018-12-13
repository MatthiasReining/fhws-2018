package de.fhws.app.business.news.boundary;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import de.fhws.app.business.log.boundary.Logger;
import de.fhws.app.business.log.boundary.LoggerProducerType;
import de.fhws.app.business.log.boundary.LoggerProducerType.LoggerType;
import de.fhws.app.business.log.enitity.LogMessage;

public class NewsLogListener {

	@Inject
	@LoggerProducerType(LoggerType.CONSOLE)
	Logger logger;

	public void newLogin(@Observes @NewLogin String message) {
		LogMessage lm = new LogMessage();
		lm.setMessage(message);
		logger.log(lm);
	}

	public void newLogin2(@Observes @NewLogin String message) {
		System.out.println("... " +message);
	}

}
