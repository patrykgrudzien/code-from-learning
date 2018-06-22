package me.jurik99.Lecture5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App
{
    public static void main(final String[] args)
    {
        final ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 2; i++)
        {
            executor.submit(new Processor(i));
        }

        // --- ExecutorService has its own managing thread and we want to tell this thread
        // --- to stop accepting new tasks and shut itself down when all tasks are finished
        executor.shutdown();

        System.out.println("All tasks submitted.");

        try
        {
            executor.awaitTermination(2, TimeUnit.SECONDS);
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("All tasks completed.");
    }
}

class Processor implements Runnable
{
    private int id;

    public Processor(final int id)
    {
        this.id = id;
    }

    @Override
    public void run()
    {
        System.out.println("Starting: " + id);

        try
        {
            Thread.sleep(5000);
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("Completed: " + id);
    }
}
