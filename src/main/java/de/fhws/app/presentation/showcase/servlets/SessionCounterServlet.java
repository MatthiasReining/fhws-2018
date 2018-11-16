package de.fhws.app.presentation.showcase.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/session-counter")
public class SessionCounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String COUNTER_NAME = "counter";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int counter = 0;
		if (session.getAttribute(COUNTER_NAME) != null)
			counter = (int) session.getAttribute(COUNTER_NAME);

		counter++;

		session.setAttribute(COUNTER_NAME, counter);

		response.getWriter().append("counter: " + counter);
	}

}
