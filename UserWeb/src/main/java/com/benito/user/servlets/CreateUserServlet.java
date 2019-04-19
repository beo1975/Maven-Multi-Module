package com.benito.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.benito.user.bo.UserBO;
import com.benito.user.dto.User;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet
public class CreateUserServlet extends HttpServlet {

	private static final Logger logger = Logger.getLogger(CreateUserServlet.class.getName());

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Integer id = -1;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			logger.log(Level.SEVERE, "NumberFormatException thrown");
		}

		String name = request.getParameter("name");
		String mail = request.getParameter("mail");

		User user = new User(id, name);
		user.setMail(mail);

		try {
			WebApplicationContext context = WebApplicationContextUtils
					.getRequiredWebApplicationContext(this.getServletContext());
			UserBO bo = (UserBO) context.getBean("userbo");
			bo.create(user);

		} catch (IllegalStateException | BeansException e) {
			logger.log(Level.SEVERE, "Exception thrown");
		}

		try {
			PrintWriter out = response.getWriter();
			out.print("User created!!!");

		} catch (IOException e) {
			logger.log(Level.SEVERE, "Exception thrown");
		}
	}
}
