package com.jurik99.Facade;

import java.sql.Connection;

public class HelperFacade {

	public static void generateReport(final DBTypes dbType, final ReportTypes reportType, final String tableName) {

		Connection connection = null;

		switch (dbType) {
			case MYSQL:
				connection = MySqlHelper.getMySqlDBConnection();
				final MySqlHelper mySqlHelper = new MySqlHelper();
				switch (reportType) {
					case HTML:
						mySqlHelper.generateMySqlHTMLReport(tableName, connection);
						break;
					case PDF:
						mySqlHelper.generateMySqlPDFReport(tableName, connection);
						break;
				}
				break;
			case ORACLE:
				connection = OracleHelper.getOracleDBConnection();
				final OracleHelper oracleHelper = new OracleHelper();
				switch (reportType) {
					case HTML:
						oracleHelper.generateOracleHTMLReport(tableName, connection);
						break;
					case PDF:
						oracleHelper.generateOraclePDFReport(tableName, connection);
						break;
				}
				break;
		}
	}

	public enum DBTypes {
		MYSQL, ORACLE
	}

	public enum ReportTypes {
		HTML, PDF
	}
}
