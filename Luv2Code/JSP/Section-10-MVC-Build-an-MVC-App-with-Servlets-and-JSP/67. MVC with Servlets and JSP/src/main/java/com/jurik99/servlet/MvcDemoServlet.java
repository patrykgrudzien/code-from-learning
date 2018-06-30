package com.jurik99.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/MvcDemoServlet")
public class MvcDemoServlet extends HttpServlet {

	private static final long serialVersionUID = -4189120884941525927L;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		// --- Step 0: Add data ---
		final String[] students = {"Susan", "Anil", "Mohamed", "Trupti"};
		request.setAttribute("students_list", students);

		// --- Step 1: get request dispatcher ---
		final RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view-students");
		/**
		 * In "request.getRequestDispatcher(path...)" we cannot pass relative path in project structure cause we are already in
		 * localhost:8080/MvcDemoServlet context and browser DOES NOT know where to go if we specify "FOLDER PATH" to
		 * "view-students.jsp".
		 *
		 * Instead of this, we need to create "web.xml" file and specify new DISPATCHER SERVLET which will be our JSP file.
		 * Please take a look into:
		 * <jsp-file>/view/view-students.jsp</jsp-file>
		 *
		 * IMPORTANT !!!
		 */

		// --- Step 2: forward the request to JSP ---
		requestDispatcher.forward(request, response);
	}
}
