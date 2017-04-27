package DependencyInjeciton.InjectionImpl;

public class MyDIApplication implements Consumer
{
    private MessageService service;

    public MyDIApplication(final MessageService service)
    {
        this.service = service;
    }

    @Override
    public void processMessages(final String msg, final String rec)
    {
        service.sendMessage(msg, rec);
    }
}
