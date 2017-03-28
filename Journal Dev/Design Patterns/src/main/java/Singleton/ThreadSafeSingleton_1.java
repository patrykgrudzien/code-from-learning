package Singleton;

public class ThreadSafeSingleton_1
{
    private static ThreadSafeSingleton_1 instance;

    private ThreadSafeSingleton_1()
    {

    }

    public static ThreadSafeSingleton_1 getInstance()
    {
        if (instance == null)
        {
            synchronized (ThreadSafeSingleton_1.class)
            {
                instance = new ThreadSafeSingleton_1();
            }
        }
        return instance;
    }

    // ================================================================================================ //

    public static void main(String[] args)
    {
        ThreadSafeSingleton_1 singleton = ThreadSafeSingleton_1.getInstance();
    }
}
