package DependencyInjeciton.InjectionImpl;

public interface MessageService
{
    /**
     * Dependency Injection in java requires at least following:
     * <p>
     * 1) Service components should be designed with base class or interface. It’s better to prefer interfaces or abstract classes
     * that would define contract for the services.
     * <p>
     * 2) Consumer classes should be written in terms of serviceImpl interface.
     * <p>
     * 3) Injector classes that will initialize the services and then the consumer classes.
     */
    void sendMessage(final String message, final String receiver);
}
