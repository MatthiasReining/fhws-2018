package de.fhws.app.business.log.boundary;

import de.fhws.app.business.log.enitity.LogMessage;

public class ConsoleLogger implements Logger {

	public void log(LogMessage message) {
		System.out.println("Console Logger: " + message);
	}
}
