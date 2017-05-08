import java.net.URISyntaxException;

import com.jurik99.helper.ResourcesHelper;

public class TableCreatorTest
{
	public static void main(final String[] args)
	{
		try
		{
			final String createDatabaseTableSQLScriptPath = ResourcesHelper.getFullPathToResourceScript(
					TableCreatorTest.class, "create-database.sql");
			System.out.println(createDatabaseTableSQLScriptPath);
		}
		catch (final URISyntaxException exception)
		{
			exception.printStackTrace();
		}
	}
}
