package de.fhws.app.presentation.showcase.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/*")
public class FrontControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getPathInfo();		
		
		System.out.println(path);

		// analyze path
		
		path = path.substring(1);
		path = path.substring(0, 1).toUpperCase() + path.substring(1);

		String className = path;

		try {
			Class clazz = Class.forName("de.fhws.app.presentation.showcase.frontcontrolle.commands." + className + "Command");

			Object cmdInstance = clazz.newInstance();
			Command cmd = (Command) cmdInstance;

			String result = cmd.doProcess(req, resp);

			resp.getWriter().println(result);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}

	}

}
