package de.fhws.app.presentation.showcase.cdi;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("msg-servlet")
public class MsgServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	Message message;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet object: " + this);
		System.out.println("message: " + message);
		resp.getWriter().println(message);
	}

}
