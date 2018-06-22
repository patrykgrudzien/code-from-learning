package com.jurik99;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	public static Connection getConnection() {
		final Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		Connection connection = null;

		try {
			fileInputStream = new FileInputStream("/db.properties");
			properties.load(fileInputStream);

			// --- LOAD THE DRIVER CLASS ---
			Class.forName(properties.getProperty("DB_DRIVER_CLASS"));

			// --- CREATE THE CONNECTION NOW ---
			connection = DriverManager.getConnection(properties.getProperty("DB_URL"),
			                                         properties.getProperty("DB_USERNAME"),
			                                         properties.getProperty("DB_PASSWORD"));
		}
		catch (IOException | ClassNotFoundException | SQLException exception) {
			exception.printStackTrace();
		}
		return connection;
	}
}
