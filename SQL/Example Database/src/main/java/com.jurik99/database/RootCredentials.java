package com.jurik99.database;

public interface RootCredentials
{
	// --- JDBC driver name and database URL for "sys" schema ---
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	String DB_ROOT_URL = "jdbc:mysql://localhost:3306/sys?useSSL=false";

	// --- ROOT user and password ---
	String ROOT_USER = "root";
	String ROOT_PASSWORD = "password";
}
