package me.jurik99.Lecture3;

public class App
{
    private int count = 0;

    public synchronized void increment()
    {
        count++;
    }

    public static void main(String[] args)
    {
        App app = new App();
        app.doWork();
    }

    public void doWork()
    {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++)
            {
                increment();
                // count = count + 1 (3 OPERATIONS !!!)
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++)
            {
                // count++;
                increment();
            }
        });

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);
    }
}
