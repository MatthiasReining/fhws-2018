package de.fhws.app.showcase.pattern;

import org.junit.Test;

import de.fhws.app.presentation.showcase.pattern.GlobalCounter;

public class SingeltonTest {

	@Test
	public void test() {

		GlobalCounter gc = GlobalCounter.getInstance();

		System.out.println(gc.incr());
		System.out.println(gc.incr());
		System.out.println(gc.incr());

		GlobalCounter gc2 = GlobalCounter.getInstance();

		System.out.println(gc2.incr());
		System.out.println(gc.incr());
		System.out.println(gc2.incr());
	}
}
