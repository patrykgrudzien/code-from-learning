package com.jurik99.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class CloseResourcesHelper
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

	public static void closeJDBCResources(final Connection connection, final Statement statement,
	                                      final ResultSet resultSet)
	{
		closeResultSet(resultSet);
		closeStatement(statement);
		closeConnection(connection);
	}
}
