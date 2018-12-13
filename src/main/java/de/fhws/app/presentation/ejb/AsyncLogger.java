package de.fhws.app.presentation.ejb;

import javax.ejb.Stateless;

@Stateless
public class AsyncLogger {

	
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
