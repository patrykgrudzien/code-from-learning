package me.jurik99.Lecture10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner
{
    private int count = 0;

    private Lock reentrantLock = new ReentrantLock();

    public void increment()
    {
        for (int i = 0; i < 10000; i++)
        {
            count++;
        }
    }

    public void firstThread() throws InterruptedException
    {
        reentrantLock.lock();

        try
        {
            increment();
        }
        finally
        {
            reentrantLock.unlock();
        }
    }

    public void secondThread() throws InterruptedException
    {
        reentrantLock.lock();

        try
        {
            increment();
        }
        finally
        {
            reentrantLock.unlock();
        }
    }

    public void finished()
    {
        System.out.println("Count is: " + count);
    }
}
