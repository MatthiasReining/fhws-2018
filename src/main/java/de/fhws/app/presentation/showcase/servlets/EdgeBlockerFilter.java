package de.fhws.app.presentation.showcase.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/*" })
public class EdgeBlockerFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String userAgent = httpRequest.getHeader("User-Agent");

		if (userAgent != null && userAgent.toLowerCase().contains("eXXXdge")) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.getWriter().println("Edge ist doof...");
			httpResponse.setStatus(418);
			return;
		}

		chain.doFilter(request, response);
	}

}
