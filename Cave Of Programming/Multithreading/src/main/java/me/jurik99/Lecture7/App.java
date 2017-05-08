package me.jurik99.Lecture7;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App
{
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(final String[] args)
    {
        final Thread t1 = new Thread(App::producer);
        final Thread t2 = new Thread(App::consumer);

        t1.start();
        t2.start();

        try
        {
            // --- wait until these threads are finished
            t1.join();
            t2.join();
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void producer()
    {
        final Random random = new Random();

        while (true)
        {
            try
            {
                final int addedValue = random.nextInt(100);
                queue.put(addedValue);
                System.out.println("Added value: " + addedValue + ", SIZE IS: " + queue.size());
            }
            catch (final InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    private static void consumer()
    {
        final Random random = new Random();

        while (true)
        {
            try
            {
                Thread.sleep(100);

                if (random.nextInt(10) == 0)
                {
                    final Integer value = queue.take();

                    System.out.println(
                            "Taken value: " + value + "; Queue size is: " + queue.size());
                }

            }
            catch (final InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
