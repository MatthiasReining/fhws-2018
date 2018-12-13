package de.fhws.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.fhws.app.business.calculation.CalculationBeanRemote;

public class CalculationClientApp {

	public static void main(String... args) throws NamingException {

		CalculationBeanRemote calculator = lookupRemoteStatelessCalculator();

		System.out.println(calculator.calc(100l));
	}

	static Context createInitialContext() throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		return new InitialContext(jndiProperties);
	}

	/**
	 * Looks up and returns the proxy to remote stateless calculator bean
	 *
	 * @return
	 * @throws NamingException
	 */
	static CalculationBeanRemote lookupRemoteStatelessCalculator() throws NamingException {

		// lookup

		final Properties jndiProperties = new Properties();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		// create the context
		final Context context = new InitialContext(jndiProperties);

		// Hashtable<String, String> jndiProperties = new Hashtable<>();
		// jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		// final Context context = new InitialContext(jndiProperties);

		// The JNDI lookup name for a stateless session bean has the syntax of:
		// ejb:<appName>/<moduleName>/<distinctName>/<beanName>!<viewClassName>
		//
		// <appName> The application name is the name of the EAR that the EJB is
		// deployed in
		// (without the .ear). If the EJB JAR is not deployed in an EAR then this is
		// blank. The app name can also be specified in the EAR's application.xml
		//
		// <moduleName> By the default the module name is the name of the EJB JAR file
		// (without the
		// .jar suffix). The module name might be overridden in the ejb-jar.xml
		//
		// <distinctName> : WildFly allows each deployment to have an (optional)
		// distinct name.
		// This example does not use this so leave it blank.
		//
		// <beanName> : The name of the session been to be invoked.
		//
		// <viewClassName>: The fully qualified classname of the remote interface. Must
		// include
		// the whole package name.
		// let's do the lookup
		return (CalculationBeanRemote) context.lookup(
				"ejb:/javaee-0.0.1-SNAPSHOT//CalculationBean!de.fhws.app.business.calculation.CalculationBeanRemote");

	}

}
