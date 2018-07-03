package mysql;

import com.jurik99.model.factory.User;
import com.jurik99.model.factory.UserFactory;
import com.jurik99.model.type.UserType;

public class NewUserCreationTest
{
	public static void main(final String[] args)
	{
		final User mySqlUser = UserFactory.getSpecificUser(UserType.MYSQL, "postgres",
		                                                   "provide user name!",
		                                                   "provide user password");
		mySqlUser.createNewUser();
	}
}
