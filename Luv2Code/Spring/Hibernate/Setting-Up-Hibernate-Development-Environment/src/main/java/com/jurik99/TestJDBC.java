package com.jurik99;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.jurik99.Constants.DB_ROOT_URL;
import static com.jurik99.Constants.ROOT_PASSWORD;
import static com.jurik99.Constants.ROOT_USER;

public class TestJDBC {

	public static void main(final String[] args) {

		try {
			System.out.println("Connecting to database: " + DB_ROOT_URL);

			final Connection connection = DriverManager.getConnection(DB_ROOT_URL, ROOT_USER, ROOT_PASSWORD);
			System.out.println("Connection successful !!!");
		}
		catch (final Exception exception) {
			exception.printStackTrace();
		}
	}
}
