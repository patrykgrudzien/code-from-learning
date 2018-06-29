package com.jurik99;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 3790586623234912642L;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		// --- Step 1: set the content type ---
		response.setContentType("text/html");

		// --- Step 2: get the printwriter ---
		final PrintWriter writer = response.getWriter();

		// --- Step 3: generate HTML content ---
		writer.println("<html><body>");

		writer.println("The student is confirmed: " +
		               request.getParameter("firstName") + " " + request.getParameter("lastName"));

		writer.println("</body></html>");
	}
}
