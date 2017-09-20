package com.jurik99;

import org.postgresql.ds.PGPoolingDataSource;

import javax.sql.DataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyDataSourceFactory {

	/**
	 * Most of the times we are looking for loose coupling for connectivity so that we can switch databases easily,
	 * connection pooling for transaction management and distributed systems support.
	 *
	 * JDBC DataSource is the preferred approach if you are looking for any of these features in your application.
	 *
	 * Some of the common features provided by JDBC DataSource implementation classes are;
	 * 1) Caching of PreparedStatement for faster processing
	 * 2) Connection timeout settings
	 * 3) Logging features
	 * 4) ResultSet maximum size threshold
	 */

	public static DataSource getPostgreSQLDataSource() {
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;

		PGPoolingDataSource postgreSQLDataSource = null;


		try {
			fileInputStream = new FileInputStream("/db.properties");
			properties.load(fileInputStream);
			postgreSQLDataSource = new PGPoolingDataSource();
			postgreSQLDataSource.setServerName("DB_URL");
			postgreSQLDataSource.setUser("DB_USERNAME");
			postgreSQLDataSource.setPassword("DB_PASSWORD");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return postgreSQLDataSource;
	}
}
