package de.fhws.app.presentation.ejb;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
public class AsyncLogger {

	@Interceptors(EjbMethodDurationLogger.class)
	@Asynchronous
	public void fireAndForget(String message) {
		// heavy work
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("log: " + message);

	}

}
