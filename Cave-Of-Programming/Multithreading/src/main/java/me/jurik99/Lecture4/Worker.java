package me.jurik99.Lecture4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker
{
    private Random random = new Random();

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    @SuppressWarnings("Duplicates")
    public void stageOne()
    {
        synchronized (lock1)
        {
            try
            {
                Thread.sleep(1);
            }
            catch (final InterruptedException e)
            {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    @SuppressWarnings("Duplicates")
    public void stageTwo()
    {
        synchronized (lock2)
        {
            try
            {
                Thread.sleep(1);
            }
            catch (final InterruptedException e)
            {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    public void process()
    {
        for (int i = 0; i < 1000; i++)
        {
            stageOne();
            stageTwo();
        }
    }

    public void main()
    {
        System.out.println("Starting...");

        final long start = System.currentTimeMillis();

        final Thread t1 = new Thread(() -> {
            process();
        });

        final Thread t2 = new Thread(() -> {
            process();
        });

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
        }

        final long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
        System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
    }
}
