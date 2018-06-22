package me.jurik99.Lecture1.demo2;

public class App
{
    public static void main(final String[] args)
    {
        final Thread t1 = new Thread(new Runner());
        final Thread t2 = new Thread(new Runner());

        t1.start();
        t2.start();
    }
}

class Runner implements Runnable
{
    @SuppressWarnings("Duplicates")
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("Hello " + i);
            try
            {
                Thread.sleep(1000);
            }
            catch (final InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}