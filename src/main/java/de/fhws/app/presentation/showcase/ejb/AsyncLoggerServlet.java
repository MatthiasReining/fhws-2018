package de.fhws.app.presentation.showcase.ejb;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("async-logger")
public class AsyncLoggerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	AsyncLogger logger;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.getWriter().println("servlet#1");
		System.out.println("servlet#1");

		logger.fireAndForget("test message");

		resp.getWriter().println("servlet#2");
		System.out.println("servlet#2");
	}

}
