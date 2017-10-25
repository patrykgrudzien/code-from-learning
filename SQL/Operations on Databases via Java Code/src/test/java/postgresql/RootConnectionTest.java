package postgresql;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jurik99.database.DatabaseProperties;
import com.jurik99.model.factory.User;
import com.jurik99.model.factory.UserFactory;
import com.jurik99.model.type.UserType;

public class RootConnectionTest
{
	private static final Logger logger = Logger.getLogger(RootConnectionTest.class);

	public static void main(final String[] args)
	{
		final User postgreSqlUser = UserFactory.getSpecificUser(UserType.POSTGRESQL, "postgres",
		                                                        DatabaseProperties.PostgreSQL.ROOT_USER,
		                                                        DatabaseProperties.PostgreSQL.ROOT_PASSWORD);
		Connection rootConnection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try
		{
			rootConnection = postgreSqlUser.createRootConnection();
			statement = rootConnection.createStatement();
			resultSet = statement.executeQuery(DatabaseProperties.PostgreSQL.Queries.SELECT_ALL_CREATED_SCHEMAS);

			if (resultSet != null)
			{
				logger.info("Query executed successfully.");
				int id = 1;

				while (resultSet.next())
				{
					final String schemaName = resultSet.getString(DatabaseProperties.PostgreSQL.Columns.SCHEMA_NAME_COLUMN);
					System.out.println(id + ". " + schemaName);
					id++;
				}
				logger.info("You've created \"" + (id - 1) + "\" schema(s) so far.");
			}
		}
		catch (final SQLException exception)
		{
			logger.error(exception.getMessage());
		}
	}
}
