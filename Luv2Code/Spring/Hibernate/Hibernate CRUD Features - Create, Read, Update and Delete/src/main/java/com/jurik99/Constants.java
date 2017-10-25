package com.jurik99;

public interface Constants {
	String JDBC_DRIVER = "org.postgresql.Driver";
	String DB_ROOT_URL = "jdbc:postgresql://localhost:5432/luv2code";
	String ROOT_USER = "postgres";
	String ROOT_PASSWORD = "password";

	interface Schemas {
		String CONFIGURATION_WITH_ANNOTATIONS = "configuration_with_annotations";
	}

	interface DatabaseNames {
		String LUV2CODE_DATABASE = "luv2code";
	}
}
