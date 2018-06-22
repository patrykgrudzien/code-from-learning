package com.jurik99.Facade;

import java.sql.Connection;

public class FacadePatternTest {

	public static void main(final String[] args) {

		final String tableName = "Employee";

		// --- GENERATING MYSQL HTML REPORT AND ORACLE PDF REPORT (WITHOUT) USING FACADE ---
		final Connection connection1 = MySqlHelper.getMySqlDBConnection();

		final MySqlHelper mySqlHelper = new MySqlHelper();
		mySqlHelper.generateMySqlHTMLReport(tableName, connection1);

		final Connection connection2 = OracleHelper.getOracleDBConnection();
		final OracleHelper oracleHelper = new OracleHelper();
		oracleHelper.generateOraclePDFReport(tableName, connection2);

		System.out.println("--------------------------------------------");

		// --- GENERATING MYSQL HTML REPORT AND ORACLE PDF REPORT (USING) FACADE ---
		HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, tableName);
		HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, tableName);
	}
}
