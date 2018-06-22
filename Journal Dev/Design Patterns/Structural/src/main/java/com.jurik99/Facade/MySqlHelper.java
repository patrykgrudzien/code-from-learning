package com.jurik99.Facade;

import java.sql.Connection;

public class MySqlHelper {

	public static Connection getMySqlDBConnection() {
		// get MySql DB connection using connection parameters
		System.out.println("getMySqlDBConnection()");
		return null;
	}

	public void generateMySqlPDFReport(final String tableName, final Connection connection) {
		// get data from table and generate pdf report
		System.out.println("generateMySqlPDFReport()");
	}

	public void generateMySqlHTMLReport(final String tableName, final Connection connection) {
		// get data from table and generate html report
		System.out.println("generateMySqlHTMLReport()");
	}
}
