package de.fhws.app.presentation.showcase.ejb;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("ejb-test")
public class EjbServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	Ejb1 ejb1;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("before ejb1#run1");

		try {
			ejb1.run1();
		} catch (EJBException e) {
			if (e.getCause().getClass().equals(BusinessException.class))
				System.out.println("busines exception is thrown: " + e.getMessage());
			else
				throw e;
		}
		System.out.println("after ejb1#run1");
	}

}
