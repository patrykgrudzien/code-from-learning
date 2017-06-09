package com.jurik99.database;

public interface DatabaseProperties
{
	interface MySQL
	{
		// --- MySQL JDBC driver name and database URL for "sys" schema ---
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

		interface Queries
		{
			String SELECT_USERS_SUMMARY = "SELECT * FROM mysql.user";
			String SELECT_USERS_SUMMARY_NOT_BACKGROUD = "SELECT * FROM user_summary WHERE user <> 'background'";
			String CREATE_NEW_USER = "CREATE USER '%1$s'@'localhost' IDENTIFIED BY '%2$s';";
			String GRANT_ALL_PRIVILAGES = "GRANT ALL PRIVILEGES ON * . * TO '%1$s'@'localhost';";
		}

		interface Columns
		{
			String USER_NAME_COLUMN = "User";
		}
	}

	interface PostgreSQL
	{
		String JDBC_DRIVER = "org.postgresql.Driver";
		String DB_ROOT_URL = "jdbc:postgresql://localhost:5432/hibernatedb?useSSL=false";
		String DB_GENERIC_URL = "";

		// --- ROOT user and password ---
		String ROOT_USER = "postgres";
		String ROOT_PASSWORD = "password";

		interface Queries
		{
			String SELECT_ALL_FROM_USER_DETAILS_VALUE_TYPES_TABLE = "SELECT * FROM value_types_and_embedding_objects.user_details";
			String SELECT_ALL_CREATED_SCHEMAS = "select schema_name from information_schema.schemata where schema_name "
			                                    + "not like 'public' and schema_name not like 'pg%' and schema_name "
			                                    + "not like 'information_schema'";
			String CREATE_SCHEMA = "CREATE SCHEMA %s";
		}

		interface Columns
		{
			String SCHEMA_NAME_COLUMN = "schema_name";
		}
	}
}
