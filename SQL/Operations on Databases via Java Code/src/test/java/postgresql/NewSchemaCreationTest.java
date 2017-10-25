package postgresql;

import com.jurik99.database.DatabaseProperties;
import com.jurik99.model.domain.Schema;
import com.jurik99.model.factory.User;
import com.jurik99.model.factory.UserFactory;
import com.jurik99.model.type.UserType;

public class NewSchemaCreationTest
{
	public static void main(final String[] args)
	{
		final User postgreSQLUser = UserFactory.getSpecificUser(UserType.POSTGRESQL, "postgres",
		                                                        DatabaseProperties.PostgreSQL.ROOT_USER,
		                                                        DatabaseProperties.PostgreSQL.ROOT_PASSWORD);

		final Schema schema = new Schema.Builder().schemaName("test_schema_from_java_code")
		                                          .build();

		postgreSQLUser.createNewSchema(schema);
	}
}
