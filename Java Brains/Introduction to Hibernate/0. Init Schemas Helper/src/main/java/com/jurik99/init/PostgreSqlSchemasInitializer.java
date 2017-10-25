package com.jurik99.init;

import com.jurik99.database.DatabaseProperties;
import com.jurik99.model.domain.Schema;
import com.jurik99.model.factory.User;
import com.jurik99.model.factory.UserFactory;
import com.jurik99.model.type.UserType;

public abstract class PostgreSqlSchemasInitializer
{
	public static void initSchemaInDatabase(final String databaseName, final String schemaName, final String userName,
	                                        final String password)
	{
		final User postgreSqlUser = UserFactory.getSpecificUser(UserType.POSTGRESQL, databaseName, userName, password);

		final Schema schema = new Schema.Builder().schemaName(schemaName).build();
		postgreSqlUser.createNewSchema(schema);
	}

	public static void initSchemaInDatabase(final String databaseName, final String schemaName)
	{
		final User postgreSqlUser = UserFactory.getSpecificUser(UserType.POSTGRESQL, databaseName,
		                                                        DatabaseProperties.PostgreSQL.ROOT_USER,
		                                                        DatabaseProperties.PostgreSQL.ROOT_PASSWORD);

		final Schema schema = new Schema.Builder().schemaName(schemaName).build();
		postgreSqlUser.createNewSchema(schema);
	}
}
