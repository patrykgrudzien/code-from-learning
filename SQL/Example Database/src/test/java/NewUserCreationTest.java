import com.jurik99.helper.UserHelper;
import com.jurik99.model.User;

public class NewUserCreationTest
{
	public static void main(String[] args)
	{
		UserHelper.createNewUser(new User("user-for-examples", "test"));
	}
}
