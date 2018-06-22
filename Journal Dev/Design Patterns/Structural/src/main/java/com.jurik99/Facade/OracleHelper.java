package com.jurik99.Facade;

import java.sql.Connection;

public class OracleHelper {

	public static Connection getOracleDBConnection() {
		// get Oracle DB connection using connection parameters
		System.out.println("getOracleDBConnection()");
		return null;
	}

	public void generateOraclePDFReport(final String tableName, final Connection connection) {
		// get data from table and generate pdf report
		System.out.println("generateOraclePDFReport()");
	}

	public void generateOracleHTMLReport(final String tableName, final Connection connection) {
		// get data from table and generate html report
		System.out.println("generateOracleHTMLReport()");
	}
}
