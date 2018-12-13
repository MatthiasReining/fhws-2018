package de.fhws.app.presentation.showcase.cdi;

import javax.enterprise.inject.Produces;

import de.fhws.app.business.log.enitity.LogMessage;

public class MessageFactory {

	@Produces
	@MessageWithInitStatement
	public LogMessage produceLogMessage() {
		LogMessage lm = new LogMessage();
		lm.setMessage("from producer");
		return lm;
	}
}
