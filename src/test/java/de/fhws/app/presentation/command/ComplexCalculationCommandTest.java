package de.fhws.app.presentation.command;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComplexCalculationCommandTest {
	
	ComplexCalculationCommand cut;
	
	@Before
	public void init() {
		cut = new ComplexCalculationCommand();
	}

	@Test
	public void shouldWork() {		
		String result = cut.doProcess(null, null);
		Assert.assertNotNull(result);
		Assert.assertEquals("42", result);
	}
	
	@Test
	public void shouldHaveWrongResult() {		
		String result = cut.doProcess(null, null);
		Assert.assertNotNull(result);
		Assert.assertNotEquals("41", result);
	}

}
