package de.fhws.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HtmlContentServlet
 */
@WebServlet("/html")
public class HtmlContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		// TODO Auto-generated method stub
		response.getWriter().println("test 1: Hello <b>FHWS</b>\nnext line");
		response.getWriter().println("test 2: Hello <b>FHWS</b><br>next line");
	}

}
