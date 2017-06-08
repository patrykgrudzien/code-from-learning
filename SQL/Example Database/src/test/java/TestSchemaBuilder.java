import com.jurik99.model.domain.Schema;

public class TestSchemaBuilder
{
	public static void main(final String[] args)
	{
		final Schema schema = new Schema.Builder()
				                      .schemaName("schema_name")
				                      .columnName("column_name")
				                      .build();

		System.out.println(schema.getSchemaName());
		System.out.println(schema.getColumnName());
	}
}
