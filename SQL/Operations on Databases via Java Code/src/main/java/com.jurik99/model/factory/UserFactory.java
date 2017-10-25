package com.jurik99.model.factory;

import org.apache.log4j.Logger;

import com.jurik99.model.impl.MySQLUser;
import com.jurik99.model.impl.PostgreSQLUser;
import com.jurik99.model.type.UserType;

public abstract class UserFactory
{
	private static final Logger logger = Logger.getLogger(UserFactory.class);

	public static User getSpecificUser(final UserType userType, final String databaseName, final String userName, final String userPassword)
	{
		if (userType != null)
		{
			switch (userType)
			{
				case MYSQL:
					return new MySQLUser(databaseName, userName, userPassword);
				case POSTGRESQL:
					return new PostgreSQLUser(databaseName, userName, userPassword);
				default:
					logger.warn("None user type has been provided!");
					return null;
			}
		}
		else
			return null;
	}
}
