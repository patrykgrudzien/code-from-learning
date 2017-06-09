package com.jurik99.model.impl;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.jurik99.database.DatabaseProperties;
import com.jurik99.model.domain.Schema;
import com.jurik99.model.factory.User;

public class PostgreSQLUser extends User
{
	private static final Logger logger = Logger.getLogger(PostgreSQLUser.class);

	private String postrgreSqlUserName;
	private String postrgreSqlUserPassword;

	public PostgreSQLUser(final String postrgreSqlUserName, final String postrgreSqlUserPassword)
	{
		this.postrgreSqlUserName = postrgreSqlUserName;
		this.postrgreSqlUserPassword = postrgreSqlUserPassword;
	}

	@Override
	public String getUserName()
	{
		return postrgreSqlUserName;
	}

	@Override
	public void setUserName(final String userName)
	{
		this.postrgreSqlUserName = userName;
	}

	@Override
	public String getUserPassword()
	{
		return postrgreSqlUserPassword;
	}

	@Override
	public void setUserPassword(final String userPassword)
	{
		this.postrgreSqlUserPassword = userPassword;
	}

	@Override
	public String getJdbcDriver()
	{
		return DatabaseProperties.PostgreSQL.JDBC_DRIVER;
	}

	@Override
	public String getDatabaseGenericURL()
	{
		return "";
	}

	@Override
	public String getDatabaseRootURL()
	{
		return DatabaseProperties.PostgreSQL.DB_ROOT_URL;
	}

	@Override
	public String getRootUser()
	{
		return DatabaseProperties.PostgreSQL.ROOT_USER;
	}

	@Override
	public String getRootPassword()
	{
		return DatabaseProperties.PostgreSQL.ROOT_PASSWORD;
	}

	@Override
	public List<String> getAllUsersNames()
	{
		return null;
	}

	@Override
	public boolean doesUserExist()
	{
		return false;
	}

	@Override
	public void createNewUser()
	{

	}

	@Override
	public void createTable(final String pathToSQLScript)
	{

	}

	@Override
	public void createNewSchema(final Schema schema)
	{
		final Connection connection;
		final Statement statement;

		try
		{
			if (doesSchemaExist(schema))
			{
				logger.warn("Cannot create new schema because it already exists!");
				return;
			}
			else
			{
				connection = createRootConnection();
				statement = connection.createStatement();

				statement.executeUpdate(String.format(DatabaseProperties.PostgreSQL.Queries.CREATE_SCHEMA,
				                                      schema.getSchemaName()));
				logger.info("Schema created successfully.");
			}
		}
		catch (final SQLException exception)
		{
			logger.error(exception.getMessage());
			return;
		}
		finally
		{
			logger.info("Resources have been closed.");
		}
	}
}
