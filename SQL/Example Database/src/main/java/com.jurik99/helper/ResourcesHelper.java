package com.jurik99.helper;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ResourcesHelper
{
	public static void closeConnection(final Connection connection)
	{
		if (connection != null)
		{
			try
			{
				connection.close();
			}
			catch (final SQLException exception)
			{
				System.out.println("CANNOT CLOSE CONNECTION !!!");
				exception.printStackTrace();
			}
		}
	}

	public static void closeStatement(final Statement statement)
	{
		if (statement != null)
		{
			try
			{
				statement.close();
			}
			catch (final SQLException exception)
			{
				System.out.println("CANNOT CLOSE STATEMENT !!!");
				exception.printStackTrace();
			}
		}
	}

	public static void closeResultSet(final ResultSet resultSet)
	{
		if (resultSet != null)
		{
			try
			{
				resultSet.close();
			}
			catch (final SQLException exception)
			{
				System.out.println("CANNOT CLOSE RESULT SET !!!");
				exception.printStackTrace();
			}
		}
	}

	public static void closeJDBCResources(final ResultSet resultSet, final Statement statement,
	                                      final Connection connection)
	{
		closeResultSet(resultSet);
		closeStatement(statement);
		closeConnection(connection);
	}

	@SuppressWarnings("SameParameterValue")
	public static String getFullPathToResourceScript(final Class<?> clazz, final String resourceName)
			throws URISyntaxException
	{
		final URL resource = clazz.getClassLoader().getResource(resourceName);
		return resource != null ? new File(resource.toURI()).getAbsolutePath() : "Script NOT FOUND!";
	}
}