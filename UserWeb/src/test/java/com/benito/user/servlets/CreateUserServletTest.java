package com.benito.user.servlets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class CreateUserServletTest {

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testDoPost() throws IOException, ServletException {

		Mockito.when(request.getParameter("id")).thenReturn("1");
		Mockito.when(request.getParameter("name")).thenReturn("John Doe");

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		Mockito.when(response.getWriter()).thenReturn(pw);

		CreateUserServlet myServlet = new CreateUserServlet();
		myServlet.doPost(request, response);

		String result = sw.getBuffer().toString().trim();

		assertEquals(result, new String("User created!!!"));
	}
}
