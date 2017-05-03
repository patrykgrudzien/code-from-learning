package com.jurik99.database;

import com.ibatis.common.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.jurik99.helper.ConnectionHelper;
import com.jurik99.helper.ResourcesHelper;
import com.jurik99.model.User;

public abstract class DatabaseTableCreator
{
	private static Statement statement;

	public static void createTable(final String pathToSQLScript, final User user)
	{
		// --- MySQL connection ---
		final Connection connection = ConnectionHelper.createConnectionToUser(user);
		try
		{
			statement = connection.createStatement();

			// --- Initialize object for ScriptRunner ---
			final ScriptRunner scriptRunner = new ScriptRunner(connection, false, false);

			// --- Give the input file to Reader ---
			final Reader reader = new BufferedReader(new FileReader(pathToSQLScript));

			// --- Execute script ---
			scriptRunner.runScript(reader);
		}
		catch (final SQLException | IOException exception)
		{
			System.out.println("SQL script has nor been found.");
			exception.printStackTrace();
		}
		finally
		{
			ResourcesHelper.closeStatement(statement);
			ResourcesHelper.closeConnection(connection);
		}
	}
}
