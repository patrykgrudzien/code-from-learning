package com.jurik99.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.jurik99.database.DatabaseCredentials.DB_GENERIC_URL;
import static com.jurik99.database.DatabaseCredentials.DB_ROOT_URL;
import static com.jurik99.database.DatabaseCredentials.JDBC_DRIVER;
import static com.jurik99.database.DatabaseCredentials.ROOT_PASSWORD;
import static com.jurik99.database.DatabaseCredentials.ROOT_USER;

import com.jurik99.model.User;

public abstract class ConnectionHelper
{
	private static Connection connection;

	public static Connection createRootConnection()
	{
		try
		{
			registerJDBCDriver();

			System.out.println("Connecting to database.");
			connection = DriverManager.getConnection(DB_ROOT_URL, ROOT_USER, ROOT_PASSWORD);
		}
		catch (final SQLException exception)
		{
			System.out.println("CANNOT CONNECT TO DATABASE !!!");
			exception.printStackTrace();
		}
		return connection;
	}

	public static Connection createConnectionToUser(final User user)
	{
		registerJDBCDriver();

		System.out.println("Connecting to database.");
		try
		{
			connection = DriverManager.getConnection(createDatabaseURLForUser(user), user.getName(),
			                                         user.getPassword());
		}
		catch (final SQLException exception)
		{
			System.out.println("CANNOT CONNECT TO DATABASE !!!");
			exception.printStackTrace();
		}
		return connection;
	}

	private static void registerJDBCDriver()
	{
		try
		{
			Class.forName(JDBC_DRIVER);
		}
		catch (final ClassNotFoundException exception)
		{
			System.out.println("Cannot find JDBC driver.");
			exception.printStackTrace();
		}
	}

	private static String createDatabaseURLForUser(final User user)
	{
		return String.format(DB_GENERIC_URL, user.getName());
	}
}
