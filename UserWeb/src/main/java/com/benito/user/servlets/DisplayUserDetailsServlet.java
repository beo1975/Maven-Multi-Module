package com.benito.user.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayUserDetailsServlet
 */
public class DisplayUserDetailsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(DisplayUserDetailsServlet.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
		} catch (IllegalStateException e) {
			logger.log(Level.SEVERE, "IllegalStateException thrown");
		} catch (IOException e) {
			logger.log(Level.SEVERE, "IOException thrown");
		}
	}
}
