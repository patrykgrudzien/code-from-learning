package me.jurik99.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC
{
	public static void main(final String[] args)
	{
		final String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		final String user = "hbstudent";
		final String password = "hbstudent";

		Connection myConn = null;

		try
		{
			System.out.println("Connecting to database: " + jdbcUrl);

			myConn = DriverManager.getConnection(jdbcUrl, user, password);

			System.out.println("Connection successful !!!");
		}
		catch (final Exception exc)
		{
			exc.printStackTrace();
		}
		finally
		{
			if (myConn == null)
			{
				try
				{
					myConn.close();
				}
				catch (final SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
