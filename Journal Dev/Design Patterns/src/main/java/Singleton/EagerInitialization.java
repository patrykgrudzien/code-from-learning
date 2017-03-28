package Singleton;

public class EagerInitialization
{
    private static final EagerInitialization instance = new EagerInitialization();

    private EagerInitialization() {}

    public static EagerInitialization getInstance()
    {
        return instance;
    }

    public void doSomething()
    {
        System.out.println("You've created singleton instance.");
    }

    // ================================================================================================ //

    public static void main(String[] args)
    {
        EagerInitialization singleton = EagerInitialization.getInstance();
        singleton.doSomething();

        System.out.println(EagerInitialization.class.getName());
    }
}
