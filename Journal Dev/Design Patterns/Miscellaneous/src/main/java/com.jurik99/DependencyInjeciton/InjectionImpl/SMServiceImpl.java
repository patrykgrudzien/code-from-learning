package DependencyInjeciton.InjectionImpl;

public class SMServiceImpl implements MessageService
{
    @Override
    public void sendMessage(final String message, final String receiver)
    {
        System.out.println("SMS sent to " + receiver + " with Message: " + message);
    }
}
