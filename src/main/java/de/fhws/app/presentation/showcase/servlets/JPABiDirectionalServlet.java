package de.fhws.app.presentation.showcase.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhws.app.business.student.entity.ChangeLog;
import de.fhws.app.business.student.entity.Student;

@WebServlet("jpa-bidirect")
public class JPABiDirectionalServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	

	@PersistenceContext
	EntityManager em;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ChangeLog cl = em.find(ChangeLog.class, 3l);
		Student s = cl.getStudent();
		
		resp.getWriter().println("cl: " + cl);
		resp.getWriter().println("student " + s);
	}
	
	

}
