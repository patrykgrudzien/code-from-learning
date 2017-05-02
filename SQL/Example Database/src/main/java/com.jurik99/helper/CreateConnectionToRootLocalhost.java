package com.jurik99.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.jurik99.database.RootCredentials.DB_ROOT_URL;
import static com.jurik99.database.RootCredentials.JDBC_DRIVER;
import static com.jurik99.database.RootCredentials.ROOT_PASSWORD;
import static com.jurik99.database.RootCredentials.ROOT_USER;

public abstract class CreateConnectionToRootLocalhost
{
	private static Connection connection;

	public static Connection createConnection()
	{
		try
		{
			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database.");
			connection = DriverManager.getConnection(DB_ROOT_URL, ROOT_USER, ROOT_PASSWORD);
		}
		catch (final ClassNotFoundException | SQLException exception)
		{
			System.out.println("CANNOT CONNECT TO DATABASE !!!");
			exception.printStackTrace();
		}
		return connection;
	}
}
