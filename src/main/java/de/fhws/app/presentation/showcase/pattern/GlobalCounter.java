package de.fhws.app.presentation.showcase.pattern;

/**
 * Java SE Singleton
 */
public class GlobalCounter {

	int count = 0;

	private static GlobalCounter instance;

	private GlobalCounter() {
		// private constructor;
	}

	public static synchronized GlobalCounter getInstance() {
		if (instance == null)
			instance = new GlobalCounter();
		return instance;
	}

	public int incr() {
		return count++;
	}

}
