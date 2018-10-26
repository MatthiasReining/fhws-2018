package de.fhws.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhws.app.business.entity.Student;
import de.fhws.app.business.entity.Students;

@WebServlet("/init")
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	Students students;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student s = new Student();
		s.setFirstName("Max");
		s.setLastName("Mustermann");
		s.setStudentId("34567890");
		students.addStudent(s);

		s = new Student();
		s.setFirstName("John");
		s.setLastName("Doe");
		s.setStudentId("87654");
		students.addStudent(s);

		s = new Student();
		s.setFirstName("Mario");
		s.setLastName("Rossi");
		s.setStudentId("54234876543");
		students.addStudent(s);

		
		response.getWriter().println("Students are stored into the HTTP session");
	}

}
