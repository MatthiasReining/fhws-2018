package de.fhws.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		doProcess(req, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// getParameter fetches the POST payload
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.equals(password))
			response.getWriter().println("login execution");
		else {
			response.setStatus(401);
			response.getWriter().println("wrong credentials");
		}
	}

}
