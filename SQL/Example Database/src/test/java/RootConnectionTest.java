import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.jurik99.database.DatabaseCredentials.DB_ROOT_URL;
import static com.jurik99.database.DatabaseCredentials.JDBC_DRIVER;
import static com.jurik99.database.DatabaseCredentials.ROOT_PASSWORD;
import static com.jurik99.database.DatabaseCredentials.ROOT_USER;

import com.jurik99.helper.ResourcesHelper;

public class RootConnectionTest
{
	// --- SOURCES ---
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;

	private static final String SELECT_USERS_SUMMARY = "SELECT * FROM user_summary WHERE user <> 'background'";
	private static final String USER_COLUMN = "user";

	@SuppressWarnings("Duplicates")
	public static void main(String[] args)
	{
		try
		{
			// --- STEP 1. Register JDBC driver ---
			Class.forName(JDBC_DRIVER);

			// --- STEP 2. Open a connection ---
			System.out.println("Connecting to database.");
			connection = DriverManager.getConnection(DB_ROOT_URL, ROOT_USER, ROOT_PASSWORD);

			// --- STEP 3. Execute a query ---
			System.out.println("Creating statement.");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_USERS_SUMMARY);

			if (resultSet != null)
			{
				System.out.println("\nSuccessfully connected. Available users: ");
				int id = 1;

				// --- STEP 4. Extract data from result set ---
				while (resultSet.next())
				{
					final String userName = resultSet.getString(USER_COLUMN);
					System.out.println(id + ". " + userName);
					id++;
				}
			}
		}
		catch (final ClassNotFoundException | SQLException exception)
		{
			System.out.println("UNABLE TO CONNECT TO DATABASE !!!");
		}
		finally
		{
			ResourcesHelper.closeJDBCResources(connection, statement, resultSet);
		}
	}
}
