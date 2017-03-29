package me.jurik99.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet
{
	private static final long serialVersionUID = -7447962591190444749L;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException
	{
		// --- setup connection variables ---
		final String user = "springstudent";
		final String password = "springstudent";
		final String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		final String driver = "com.mysql.jdbc.Driver";

		Connection connection = null;

		// --- get connection ---
		try
		{
			final PrintWriter out = response.getWriter();

			out.println("Connecting to database: " + jdbcUrl);

			Class.forName(driver);
			connection = DriverManager.getConnection(jdbcUrl, user, password);

			out.println("SUCCESS !!!");
		}
		catch (final SQLException e)
		{
			e.printStackTrace();
		}
		catch (final ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch (final SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
