package de.fhws.app.presentation.showcase.ejb;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class EjbMethodDurationLogger {

	@AroundInvoke
	public Object logger(InvocationContext ctx) throws Exception {
		System.out.println(ctx.getMethod() + " starts");
		long start = System.currentTimeMillis();
		Object resultObj =  ctx.proceed();
		long duration = System.currentTimeMillis() - start;

		System.out.println(ctx.getMethod() + " execution took " + duration + "ms");
		
		return resultObj;

	}
}
