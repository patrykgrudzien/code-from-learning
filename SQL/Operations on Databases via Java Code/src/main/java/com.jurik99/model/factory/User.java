package com.jurik99.model.factory;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jurik99.helper.ResourcesHelper;
import com.jurik99.model.domain.Schema;

public abstract class User
{
	private static final Logger logger = Logger.getLogger(User.class);

	public abstract String getUserName();

	public abstract void setUserName(final String userName);

	public abstract String getUserPassword();

	public abstract void setUserPassword(final String userPassword);

	public abstract String getJdbcDriver();

	public abstract String getDatabaseGenericURL();

	public abstract String getDatabaseRootURL();

	public abstract String getRootUser();

	public abstract String getRootPassword();

	public abstract List<String> getAllUsersNames();

	public abstract boolean doesUserExist();

	public abstract void createNewUser();

	public abstract void createTable(final String pathToSQLScript);

	public abstract void createNewSchema(final Schema schema);

	public boolean doesSchemaExist(final Schema schema)
	{
		final List<String> listOfSchemaNames = getListOfSchemas(schema);

		for (final String tempSchemaName : listOfSchemaNames)
		{
			if (listOfSchemaNames.contains(schema.getSchemaName()) || tempSchemaName.equals(schema.getSchemaName()))
			{
				return true;
			}
		}
		return false;
	}

	public List<String> getListOfSchemas(final Schema schema)
	{
		final List<String> listOfSchemas = new ArrayList<>();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try
		{
			connection = createRootConnection();
			logger.info("Trying to retrieve list of schemas...");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(schema.getAllSchemasQuery());

			if (resultSet != null)
			{
				while (resultSet.next())
				{
					final String schemaName = resultSet.getString(schema.getColumnName());
					listOfSchemas.add(schemaName);
				}
				logger.info("Count of existing schemas is: " + listOfSchemas.size() + ". Closing connection...");
			}
		}
		catch (final SQLException exception)
		{
			logger.error("Did you provide a query to retrieve list of schemas? " + exception.getMessage());
		}
		finally
		{
			ResourcesHelper.closeJDBCResources(resultSet, statement, connection);
			logger.info("Resources have been closed.");
		}
		return listOfSchemas;
	}

	private void registerJDBCDriver()
	{
		try
		{
			Class.forName(getJdbcDriver());
		}
		catch (final ClassNotFoundException exception)
		{
			logger.error("Driver not found! " + exception);
			return;
		}
	}

	public Connection createRootConnection()
	{
		final Connection connection;

		try
		{
			registerJDBCDriver();

			connection = DriverManager.getConnection(getDatabaseRootURL(), getRootUser(), getRootPassword());
			logger.info("Connected to ROOT user.");
		}
		catch (final SQLException exception)
		{
			logger.error("Cannot connect to database! " + exception);
			return null;
		}
		return connection;
	}

	private String createDatabaseURLForUser()
	{
		return String.format(getDatabaseGenericURL(), this.getUserName());
	}

	protected Connection createConnectionToUser()
	{
		final Connection connection;
		registerJDBCDriver();

		try
		{
			connection = DriverManager.getConnection(createDatabaseURLForUser(), this.getUserName(),
			                                         this.getUserPassword());
			logger.info("Connected to NEW user.");
		}
		catch (final SQLException exception)
		{
			logger.error("Cannot connect to database! " + exception);
			return null;
		}
		return connection;
	}

	@Override
	public String toString()
	{
		return "User name: " + this.getUserName() + ", User Password: " + this.getUserPassword();
	}
}
