package com.jurik99;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * If we specify in (web.xml) file whole section below:
 *
 * <servlet>
 *     <servlet-name>TestParamServlet</servlet-name>
 *     <servlet-class>com.jurik99.TestParamServlet</servlet-class>
 * </servlet>
 *
 * <servlet-mapping>
 *     <servlet-name>TestParamServlet</servlet-name>
 *     <url-pattern>/TestParamServlet</url-pattern>
 * </servlet-mapping>
 *
 * We DO NOT have to annotate Java class with "@WebServlet("/TestParamServlet")" annotation cause we already define servlet
 * NAME, servlet CLASS and servlet MAPPING in that file !!!
 *
 * VERY IMPORTANT !!!
 */
@WebServlet("/TestParamServlet")
public class TestParamServlet extends HttpServlet {

	private static final long serialVersionUID = 2637673257717555940L;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		// --- Step 1: set content type ---
		response.setContentType("text/html");

		// --- Step 2: get printer ---
		final PrintWriter writer = response.getWriter();

		// --- Step 3: read configuration params ---
		final ServletContext servletContext = getServletContext();  // inherited from HttpServlet

		final String maxCartSize = servletContext.getInitParameter("max-shopping-cart-size");
		final String teamName = servletContext.getInitParameter("project-team-name");

		// --- Step 4: generate HTML content ---
		writer.println("<html><body>");

		writer.println("Max cart size: " + maxCartSize);
		writer.println("<br><br>");
		writer.println("Team name: " + teamName);

		writer.println("</body></html>");
	}
}
