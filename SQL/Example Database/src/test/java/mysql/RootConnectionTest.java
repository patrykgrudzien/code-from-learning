package mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jurik99.database.DatabaseProperties;
import com.jurik99.helper.ResourcesHelper;
import com.jurik99.model.factory.User;
import com.jurik99.model.factory.UserFactory;
import com.jurik99.model.type.UserType;

public class RootConnectionTest
{
	@SuppressWarnings("Duplicates")
	public static void main(final String[] args)
	{
		final User mySqlUser = UserFactory.getSpecificUser(UserType.MYSQL, DatabaseProperties.MySQL.ROOT_USER,
		                                                   DatabaseProperties.MySQL.ROOT_PASSWORD);
		Connection rootConnection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try
		{
			// --- STEP 2. Open a connection ( JDBC driver is registered inside "createRootConnection()" ) ---
			rootConnection = mySqlUser.createRootConnection();

			// --- STEP 3. Execute a query ---
			statement = rootConnection.createStatement();
			resultSet = statement.executeQuery(DatabaseProperties.MySQL.Queries.SELECT_USERS_SUMMARY_NOT_BACKGROUD);

			if (resultSet != null)
			{
				System.out.println("\nSuccessfully connected. Available users: ");
				int id = 1;

				// --- STEP 4. Extract data from result set ---
				while (resultSet.next())
				{
					final String userName = resultSet.getString(DatabaseProperties.MySQL.Columns.USER_NAME_COLUMN
							                                            .toLowerCase());
					System.out.println(id + ". " + userName);
					id++;
				}
			}
		}
		catch (final SQLException exception)
		{
			System.out.println("UNABLE TO CONNECT TO DATABASE !!!");
		}
		finally
		{
			ResourcesHelper.closeJDBCResources(resultSet, statement, rootConnection);
		}
	}
}
