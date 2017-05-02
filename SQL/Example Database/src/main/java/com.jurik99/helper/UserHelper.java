package com.jurik99.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jurik99.model.User;

public abstract class UserHelper
{
	private static Connection connection = CreateConnectionToRootLocalhost.createConnection();
	private static Statement statement;

	private static final String SELECT_USERS_SUMMARY = "SELECT * FROM mysql.user";
	private static final String USER_NAME_COLUMN = "User";
	private static final String CREATE_NEW_USER = "CREATE USER '%1$s'@'localhost' IDENTIFIED BY '%2$s';";
	private static final String GRANT_ALL_PRIVILAGES = "GRANT ALL PRIVILEGES ON * . * TO '%1$s'@'localhost';";

	public static void createNewUser(final User user)
	{
		try
		{
			System.out.println("Creating statement.");
			statement = connection.createStatement();

			/*
			 * When we want to use "executeQuery()", SQLException is thrown:
			 * Can not issue data manipulation statements with executeQuery().
			 *
			 * To manipulate data we actually need to use "executeUpdate()"
			 */
			if (doesUserExist(user))
			{
				throw new SQLException("UNABLE TO CREATE NEW USER !!!");
			}
			else
			{
				System.out.println("Successfully connected. New user: " + user.getName() + " created.");
				System.out.println("\nGo to MySQL Workbench and add newly created connection !!!");
			/*
			 * Later on we have to open MySQL Workbench and add exactly the same user that we created here !!!
			 */
			}
		}
		catch (final SQLException exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			CloseResourcesHelper.closeStatement(statement);
			CloseResourcesHelper.closeConnection(connection);
		}
	}

	private static List<String> getAllUsersNames()
	{
		final List<String> users = new ArrayList<>();

		try
		{
			statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(SELECT_USERS_SUMMARY);

			if (resultSet != null)
			{
				while (resultSet.next())
				{
					final String name = resultSet.getString(USER_NAME_COLUMN);
					users.add(name);
				}
			}
		}
		catch (final SQLException exception)
		{
			exception.printStackTrace();
		}
		return users;
	}

	private static boolean doesUserExist(final User user)
			throws SQLException
	{
		final List<String> names = getAllUsersNames();

		for (final String name : names)
		{
			if (names.contains(user.getName()) || name.equals(user.getName()))
			{
				System.out.println("USER ALREADY EXISTS !!!");
				return true;
			}
			else
			{
				statement.executeUpdate(String.format(CREATE_NEW_USER, user.getName(), user.getPassword()));
				statement.executeUpdate(String.format(GRANT_ALL_PRIVILAGES, user.getName()));
				break;
			}
		}
		return true;
	}
}
