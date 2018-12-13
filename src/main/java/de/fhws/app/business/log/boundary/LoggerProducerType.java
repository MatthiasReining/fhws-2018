package de.fhws.app.business.log.boundary;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE, ElementType.METHOD })
public @interface LoggerProducerType {

	public enum LoggerType {
		DB, CONSOLE;
	}

	LoggerType value();
}
