package de.fhws.app.presentation.showcase.cdi;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhws.app.business.log.enitity.LogMessage;

@WebServlet("cdi3")
public class CdiProducer extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	@MessageWithInitStatement
	LogMessage message;

	@Inject
	LogMessage message2;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("message: " + message);
		System.out.println("message2: " + message2);
		resp.getWriter().println("cdi3");
	}

}
