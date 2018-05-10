package DependencyInjeciton.InjectionImpl;

public class SMServiceInjector implements MessageServiceInjector
{
    @Override
    public Consumer getConsumer()
    {
        return new MyDIApplication(new SMServiceImpl());
    }
}
