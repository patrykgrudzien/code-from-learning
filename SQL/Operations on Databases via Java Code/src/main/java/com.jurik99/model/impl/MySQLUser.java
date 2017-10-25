package com.jurik99.model.impl;

import org.apache.log4j.Logger;

import com.ibatis.common.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jurik99.database.DatabaseProperties;
import com.jurik99.helper.ResourcesHelper;
import com.jurik99.model.domain.Schema;
import com.jurik99.model.factory.User;

public class MySQLUser extends User
{
	private static final Logger logger = Logger.getLogger(MySQLUser.class);

	private String mySqlUserName;
	private String mySqlUserPassword;
	private String databaseName;

	public MySQLUser(final String databaseName, final String mySqlUserName, final String mySqlUserPassword)
	{
		this.databaseName = databaseName;
		this.mySqlUserName = mySqlUserName;
		this.mySqlUserPassword = mySqlUserPassword;
	}

	@Override
	public String getUserName()
	{
		return mySqlUserName;
	}

	@Override
	public void setUserName(final String userName)
	{
		this.mySqlUserName = userName;
	}

	@Override
	public String getUserPassword()
	{
		return mySqlUserPassword;
	}

	@Override
	public void setUserPassword(final String userPassword)
	{
		this.mySqlUserPassword = userPassword;
	}

	@Override
	public String getJdbcDriver()
	{
		return DatabaseProperties.MySQL.JDBC_DRIVER;
	}

	@Override
	public String getDatabaseName() {
		return databaseName;
	}

	@Override
	public String getDatabaseGenericURL()
	{
		return DatabaseProperties.MySQL.DB_GENERIC_URL;
	}

	@Override
	public String getDatabaseRootURL()
	{
		return DatabaseProperties.MySQL.DB_ROOT_URL;
	}

	@Override
	public String getRootUser()
	{
		return DatabaseProperties.MySQL.ROOT_USER;
	}

	@Override
	public String getRootPassword()
	{
		return DatabaseProperties.MySQL.ROOT_PASSWORD;
	}

	@Override
	public List<String> getAllUsersNames()
	{
		final List<String> users = new ArrayList<>();

		try
		{
			final Connection connection = createRootConnection();
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(DatabaseProperties.MySQL.Queries.SELECT_USERS_SUMMARY);

			if (resultSet != null)
			{
				while (resultSet.next())
				{
					final String name = resultSet.getString(DatabaseProperties.MySQL.Columns.USER_NAME_COLUMN);
					users.add(name);
				}
			}
		}
		catch (final SQLException exception)
		{
			logger.error(exception.getMessage());
			return null;
		}
		return users;
	}

	@Override
	public boolean doesUserExist()
	{
		final Connection connection = createRootConnection();

		Statement statement = null;
		try
		{
			statement = connection.createStatement();
		}
		catch (final SQLException exception)
		{
			logger.error(exception.getMessage());
		}

		final List<String> names = getAllUsersNames();

		for (final String name : names)
		{
			if (names.contains(getUserName()) || name.equals(getUserName()))
			{
				logger.error("User already exists !");
				return true;
			}
			else
			{
				try
				{
					statement.executeUpdate(String.format(DatabaseProperties.MySQL.Queries.CREATE_NEW_USER,
					                                      getUserName(),
					                                      getUserPassword()));
					statement.executeUpdate(String.format(DatabaseProperties.MySQL.Queries.GRANT_ALL_PRIVILAGES,
					                                      getUserName()));
					break;
				}
				catch (final SQLException exception)
				{
					logger.error(exception.getMessage());
				}
				finally
				{
					ResourcesHelper.closeStatement(statement);
					ResourcesHelper.closeConnection(connection);
				}
			}
		}
		return false;
	}

	@Override
	public void createNewUser()
	{
		try
		{
			logger.info("Creating statement.");
			/*
			 * When we want to use "executeQuery()", SQLException is thrown:
			 * Can not issue data manipulation statements with executeQuery().
			 *
			 * To manipulate data we actually need to use "executeUpdate()"
			 */
			if (doesUserExist())
			{
				throw new SQLException("UNABLE TO CREATE NEW USER !!!");
			}
			else
			{
				logger.info("Successfully connected. New user: " + getUserName() + " created.");
				logger.info("Go to MySQL Workbench and add newly created connection!");
				/*
			     * Later on we have to open MySQL Workbench and add exactly the same user that we created here !!!
			     */
			}
		}
		catch (final SQLException exception)
		{
			logger.error(exception.getMessage());
		}
	}

	@Override
	public void createTable(final String pathToSQLScript)
	{
		// --- MySQL connection ---
		final Connection connection = createConnectionToUser();

		try
		{
			// --- Initialize object for ScriptRunner ---
			final ScriptRunner scriptRunner = new ScriptRunner(connection, false, false);

			// --- Give the input file to Reader ---
			final Reader reader = new BufferedReader(new FileReader(pathToSQLScript));

			// --- Execute script ---
			scriptRunner.runScript(reader);
		}
		catch (final SQLException | IOException exception)
		{
			logger.error("SQL script has not been found.");
			return;
		}
	}

	@Override
	public void createNewSchema(final Schema schema)
	{

	}
}
