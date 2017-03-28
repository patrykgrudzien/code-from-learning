package Singleton;

public class ThreadSafeSingleton
{
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton()
    {

    }

    public static synchronized ThreadSafeSingleton getInstance()
    {
        if (instance == null)
        {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    // ================================================================================================ //

    public static void main(String[] args)
    {
        ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
    }
}
