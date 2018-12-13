package de.fhws.app.business.log.boundary;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;

import de.fhws.app.business.log.boundary.LoggerProducerType.LoggerType;

@Stateless
public class LoggerFactory {

	@Produces
	@LoggerProducerType(LoggerType.DB)
	public Logger produceDBLogger() {
		return new DbLogger(); // FIXME use managed SLSB class
	}

	@Produces
	@LoggerProducerType(LoggerType.CONSOLE)
	public Logger produceConsoleLogger() {
		return new ConsoleLogger();
	}

}
