package de.fhws.app.presentation.showcase.servlets;

import java.util.Enumeration;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class TimeoutListener
 *
 */
@WebListener
public class TimeoutListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session created");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session destroyed");
		Enumeration<String> names = se.getSession().getAttributeNames();
		System.out.println("Session content");
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name + " : " + se.getSession().getAttribute(name));
		}
	}

}
