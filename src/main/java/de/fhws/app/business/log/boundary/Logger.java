package de.fhws.app.business.log.boundary;

import de.fhws.app.business.log.enitity.LogMessage;

public interface Logger {
	void log(LogMessage message);
}
