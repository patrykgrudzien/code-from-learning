package me.jurik99.Lecture1.demo3;

public class App
{
    @SuppressWarnings("Duplicates")
    public static void main(final String[] args)
    {
        final Thread t1 = new Thread(new Runnable()
        {
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
        });
        t1.start();
    }
}
