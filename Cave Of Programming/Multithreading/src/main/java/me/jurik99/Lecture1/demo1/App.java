package me.jurik99.Lecture1.demo1;

import me.jurik99.CreateDescriptionFile;

class Runner extends Thread
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
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

public class App
{
    public static void main(String[] args)
    {
        CreateDescriptionFile.createTextFileWithNameOfLecture(path, fileName, description);

        Runner runner1 = new Runner();
        runner1.start();

        Runner runner2 = new Runner();
        runner2.start();
    }

    // ----------------------------------------------------------------------------------------- //
    private static final String path = "D:\\Internet\\Dropbox"
                                + "\\Programowanie\\_Own "
                                + "Codes_\\src\\main\\java\\Cave Of"
                                + " Programming\\src\\Multithreading\\Lecture1\\demo1";
    private static final String fileName = "extends_Thread_class";
    private static final String description = "This App.java shows how to create Threads using "
                                       + "inherintance";
    // ----------------------------------------------------------------------------------------- //
}