package de.fhws.app.business.log.boundary;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import de.fhws.app.business.log.boundary.LoggerProducerType.LoggerType;

public class LoggerFactory {

	@Inject
	private BeanManager beanManager;

	@Produces
	@LoggerProducerType(LoggerType.DB)
	public Logger produceDBLogger() {
		Bean<DbLogger> bean = (Bean<DbLogger>) beanManager.getBeans(DbLogger.class).iterator().next();
		CreationalContext<DbLogger> ctx = beanManager.createCreationalContext(bean);
		DbLogger object = (DbLogger) beanManager.getReference(bean, DbLogger.class, ctx);
		return object;
	}

	@Produces
	@LoggerProducerType(LoggerType.CONSOLE)
	public Logger produceConsoleLogger() {
		return new ConsoleLogger();
	}

}
