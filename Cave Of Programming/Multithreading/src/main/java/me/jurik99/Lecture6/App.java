package me.jurik99.Lecture6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App
{
    public static void main(String[] args)
    {
        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++)
        {
            executorService.submit(new Processor(latch));
        }

        try
        {
            latch.await();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("Completed.");
    }
}

class Processor implements Runnable
{
    private CountDownLatch countDownLatch;

    public Processor(final CountDownLatch countDownLatch)
    {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run()
    {
        System.out.println("Started.");

        try
        {
            Thread.sleep(3000);
            countDownLatch.countDown();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
