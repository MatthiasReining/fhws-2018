package de.fhws.app.business.calculation;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(CalculationBeanRemote.class)
public class CalculationBean implements CalculationBeanRemote {

	@Override
	public long calc(long in) {
		return 42 * in;
	}
}
