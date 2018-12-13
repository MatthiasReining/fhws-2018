package de.fhws.app.business.calculation;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;

@Stateless
@Remote(CalculationBeanRemote.class)
@WebService
public class CalculationBean implements CalculationBeanRemote {

	@Override
	public long calc(@WebParam(name="input")long in) {
		return 42 * in;
	}

}
