package com.jurik99.Singleton;

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

    public static void main(final String[] args)
    {
        final ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
    }
}
