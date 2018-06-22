package me.jurik99.Lecture8;

public class App
{
    @SuppressWarnings("Duplicates")
    public static void main(final String[] args)
    {
        final Processor processor = new Processor();

        final Thread t1 = new Thread(() -> {
            try
            {
                processor.produce();
            }
            catch (final InterruptedException e)
            {
                e.printStackTrace();
            }
        });

        final Thread t2 = new Thread(() -> {
            try
            {
                processor.consume();
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
    }
}
