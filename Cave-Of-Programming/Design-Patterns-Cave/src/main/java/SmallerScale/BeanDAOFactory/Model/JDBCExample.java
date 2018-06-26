package SmallerScale.BeanDAOFactory.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * STEP 1. - Import required packages
 */
public class JDBCExample {

	// === JDBC driver name and database URL === //
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/mojaBaza";

	// === Database credentials === //
	private static final String USER = "tutorial";
	private static final String PASS = "password";

	// === Database credentials === //
	private static final String SELECT_STATEMENT = selectStatement("id", "first", "last", "age");

	// === StringBuilder === //
	private static StringBuilder selectQuery;

	// === SOURCES === //
	private static Connection connection = null;
	private static Statement statement = null;

	public static void main(final String[] args) {
		try {
			/**
			 * STEP 2. - Register JDBC driver
			 */
			Class.forName(JDBC_DRIVER);

			/**
			 * STEP 3. - Open a connection
			 */
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);

			/**
			 * STEP 4. - Execute a query
			 */
			System.out.println("Creating statement...");
			statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(SELECT_STATEMENT);

			/**
			 * STEP 5. - Extract data from result set
			 */
			while (resultSet.next()) {
				// Retrieve by column name
				final int id = resultSet.getInt("id");
				final int age = resultSet.getInt("age");
				final String first = resultSet.getString("first");
				final String last = resultSet.getString("last");

				// Display values
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", First: " + first);
				System.out.print(", Last: " + last);
				System.out.println();
			}

			/**
			 * STEP 6. - Clean up environment
			 */
			resultSet.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("UNABLE TO CONNECT TO DATABASE !!!");
			System.out.println();
			e.printStackTrace();
		} finally {
			closeSources();
			System.out.println("\n\nGoodbye :)");
		}
	}

	private static String whereClause(final String where) {
		return getSelectQuery().append(" WHERE ").append(where).toString();
	}

	private static String selectStatement(final String... columns) {
		selectQuery = new StringBuilder("SELECT ");
		for (int i = 0; i < columns.length; i++) {
			if (i == columns.length - 1)
				selectQuery.append(columns[i]).append(" ");
			else
				selectQuery.append(columns[i]).append(", ");
		}
		selectQuery.append("FROM Employees");
		return selectQuery.toString();
	}

	private static StringBuilder getSelectQuery() {
		return selectQuery;
	}

	private static void closeSources() {
		try {
			if (connection != null)
				connection.close();
		} catch (final SQLException e1) {
			e1.printStackTrace();
		}
		try {
			if (statement != null)
				statement.close();
		} catch (final SQLException e2) {
			e2.printStackTrace();
		}
	}
}
