package com.jurik99.init;

import com.jurik99.database.DatabaseProperties;
import com.jurik99.model.domain.Schema;
import com.jurik99.model.factory.User;
import com.jurik99.model.factory.UserFactory;
import com.jurik99.model.type.UserType;

public abstract class PostgreSqlSchemasInitializer
{
	public static void initSchemaInDatabase(final String schemaName)
	{
		final User postgreSqlUser = UserFactory.getSpecificUser(UserType.POSTGRESQL,
		                                                        DatabaseProperties.PostgreSQL.ROOT_USER,
		                                                        DatabaseProperties.PostgreSQL.ROOT_PASSWORD);

		final Schema schema = new Schema.Builder().schemaName(schemaName).build();
		postgreSqlUser.createNewSchema(schema);
	}
}
