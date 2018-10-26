package de.fhws.app.presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

	public String doProcess(HttpServletRequest req, HttpServletResponse resp);
}
