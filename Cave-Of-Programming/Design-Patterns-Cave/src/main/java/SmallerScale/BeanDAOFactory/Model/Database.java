package SmallerScale.BeanDAOFactory.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private static final Database instance = new Database();

	private Connection connection;

	// === JDBC driver name and database URL === //
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/mojaBaza";

	// === Database credentials === //
	private static final String USER = "tutorial";
	private static final String PASS = "password";

	private Database() {}

	public static Database getInstance() {
		return instance;
	}

	public void connect() {
		if (connection != null) {
			return;
		}

		try {
			/*
			 * STEP 2. - Register JDBC driver
			 */
			Class.forName(JDBC_DRIVER);

			/*
			 * STEP 3. - Open a connection
			 */
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isConnect() {
		return connection != null;
	}

	public void disconnect() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Disconnected from database successfully.");
			} catch (final SQLException e) {
				System.out.println("CAN'T CLOSE CONNECTION!");
			}
		}
		connection = null;
	}

	public boolean isDisconnect() {
		return connection == null;
	}

	public Connection getConnection() {
		return connection;
	}
}