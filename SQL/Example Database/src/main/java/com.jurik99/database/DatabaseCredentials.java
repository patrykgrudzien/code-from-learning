package com.jurik99.database;

public interface DatabaseCredentials
{
	// --- JDBC driver name and database URL for "sys" schema ---
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	String DB_ROOT_URL = "jdbc:mysql://localhost:3306/sys?useSSL=false";
	String DB_GENERIC_URL = "jdbc:mysql://localhost:3306/%s?useSSL=false";

	// --- ROOT user and password ---
	String ROOT_USER = "root";
	String ROOT_PASSWORD = "password";

	// --- User for Example Database module in SQL project ---
	String USER_FOR_EXAMPLES_NAME = "user-for-examples";
	String USER_FOR_EXAMPLES_PASSWORD = "examples";

	// --- User for Liquibase module ---
	String LIQUIBASE_USER_NAME = "liquibase-user";
	String LIQUIBASE_USER_PASSWORD = "liquibase";

	// --- User for JavaBrains Hibernate Tutorial ---
	String JAVA_BRAINS_HIBERNATE_USER_NAME = "java-brains-hibernate";
	String JAVA_BRAINS_HIBERNATE_USER_PASSWORD = "hibernate";
}
