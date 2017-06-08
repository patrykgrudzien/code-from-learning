package com.jurik99.model.domain;

import org.apache.log4j.Logger;

import com.jurik99.database.DatabaseProperties;

public class Schema
{
	private static final Logger logger = Logger.getLogger(Schema.class);

	private String schemaName;
	private String allSchemasQuery;
	private String columnName;

	private Schema(final Builder builder)
	{
		this.schemaName = builder.schemaName;
		this.allSchemasQuery = builder.allSchemasQuery;
		this.columnName = builder.columnName;
	}

	public String getSchemaName()
	{
		return schemaName;
	}

	public void setSchemaName(final String schemaName)
	{
		this.schemaName = schemaName;
	}

	public String getAllSchemasQuery()
	{
		return allSchemasQuery;
	}

	public void setAllSchemasQuery(final String allSchemasQuery)
	{
		this.allSchemasQuery = allSchemasQuery;
	}

	public String getColumnName()
	{
		return columnName;
	}

	public void setColumnName(final String columnName)
	{
		this.columnName = columnName;
	}

	public static class Builder
	{
		private String schemaName;
		private String allSchemasQuery;
		private String columnName;

		public Builder()
		{
			this.allSchemasQuery = DatabaseProperties.PostgreSQL.Queries.SELECT_ALL_CREATED_SCHEMAS;
			this.columnName = DatabaseProperties.PostgreSQL.Columns.SCHEMA_NAME_COLUMN;
			logger.info("In no-args constructor values for QUERY and COLUMN_NAME have been loaded from "
			            + "DatabaseProperties.PostgreSQL");
		}

		public Builder schemaName(final String schemaName)
		{
			this.schemaName = schemaName;
			return this;
		}

		public Builder allSchemasQuery(final String allSchemasQuery)
		{
			this.allSchemasQuery = allSchemasQuery;
			return this;
		}

		public Builder columnName(final String columnName)
		{
			this.columnName = columnName;
			return this;
		}

		public Schema build()
		{
			return new Schema(this);
		}
	}
}
