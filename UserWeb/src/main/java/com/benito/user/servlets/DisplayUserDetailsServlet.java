package com.benito.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;

/**
 * Servlet implementation class DisplayUserDetailsServlet
 */
public class DisplayUserDetailsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(DisplayUserDetailsServlet.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());

			/*
			 * WebApplicationContext context = WebApplicationContextUtils
			 * .getRequiredWebApplicationContext(this.getServletContext()); UserBO bo =
			 * (UserBO) context.getBean("userbo"); User user =
			 * bo.findUser(Integer.parseInt(request.getParameter("id")));
			 */
			PrintWriter out = response.getWriter();
			out.println("User details");
			/*
			 * out.println("User ID:     " + user.getId()); out.println("User Name:   " +
			 * user.getName()); out.println("User e-mail: " + user.getMail());
			 */
		} catch (NumberFormatException e) {
			logger.log(Level.SEVERE, "NumberFormatException thrown");
		} catch (BeansException e) {
			logger.log(Level.SEVERE, "BeansException thrown");
		} catch (IllegalStateException e) {
			logger.log(Level.SEVERE, "IllegalStateException thrown");
		} catch (IOException e) {
			logger.log(Level.SEVERE, "IOException thrown");
		}
	}
}
