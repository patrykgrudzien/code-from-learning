package DependencyInjeciton.InjectionImpl;

public class EmailServiceImpl implements MessageService
{
    @Override
    public void sendMessage(final String message, final String receiver)
    {
        System.out.println("EMAIL sent to " + receiver + " with Message: " + message);
    }
}
