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
@WebServlet("/session-counter2")
public class SessionCounter2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String COUNTER_NAME = "counterObject";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		Counter counter;
		if (session.getAttribute(COUNTER_NAME) == null)
			session.setAttribute(COUNTER_NAME, new Counter());
		
		counter = (Counter) session.getAttribute(COUNTER_NAME);
		counter.setCounter(counter.getCounter()+1);

		response.getWriter().append("counter object: " + counter.getCounter());
	}

}
