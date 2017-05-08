package me.jurik99.Lecture10;

public class App
{
    public static void main(final String[] args)
    {
        final Runner runner = new Runner();

        final Thread t1 = new Thread(() -> {
            try
            {
                runner.firstThread();
            }
            catch (final InterruptedException e)
            {
                e.printStackTrace();
            }
        });

        final Thread t2 = new Thread(() -> {
            try
            {
                runner.secondThread();
            }
            catch (final InterruptedException e)
            {
                e.printStackTrace();
            }
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

        runner.finished();
    }
}
