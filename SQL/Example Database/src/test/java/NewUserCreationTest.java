import com.jurik99.helper.UserHelper;
import com.jurik99.model.User;

public class NewUserCreationTest
{
	public static void main(final String[] args)
	{
		UserHelper.createNewUser(new User("liquibase-user", "liquibase"));
	}
}
