package de.fhws.app.presentation.showcase.frontcontroller.comands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhws.app.presentation.showcase.frontcontroller.Command;

public class ComplexCalculationCommand implements Command {

	@Override
	public String doProcess(HttpServletRequest req, HttpServletResponse resp) {
		return "42";
	}

}
