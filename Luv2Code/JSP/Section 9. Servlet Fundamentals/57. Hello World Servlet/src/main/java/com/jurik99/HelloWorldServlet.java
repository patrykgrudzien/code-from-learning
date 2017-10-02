package com.jurik99;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 6515955864394108633L;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		// --- Step 1: set the content type ---
		response.setContentType("text/html");

		// --- Step 2: get the printwriter ---
		final PrintWriter writer = response.getWriter();

		// --- Step 3: generate HTML content ---
		writer.println("<html><body>");

		writer.println("<h2>Hello World</h2>");
		writer.println("<hr>");
		writer.println("Time on the server is: " + new Date());

		writer.println("</body></html>");

		writer.close();
	}
}
