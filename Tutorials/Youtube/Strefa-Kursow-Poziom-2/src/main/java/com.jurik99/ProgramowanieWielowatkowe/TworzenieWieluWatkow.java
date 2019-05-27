package ProgramowanieWielowatkowe;

public class TworzenieWieluWatkow implements Runnable
{
    String nazwa;
    Thread t;

    TworzenieWieluWatkow(String nazwaWatku)
    {
        nazwa = nazwaWatku;
        t = new Thread(this, nazwa);
        System.out.println("Nowy Wątek: " + t);
        t.start();
    }

    @Override
    public void run()
    {
        try
        {
            for (int i = 5; i >= 0; i--)
            {
                System.out.println(nazwa + ": " + i);
                t.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Przerwano" + nazwa + "\n" + e);
        }
        System.out.println("Koniec wątku: " + nazwa);
    }
}

class Demo1
{
    public static void main(String[] args)
    {
        new TworzenieWieluWatkow("Pierwszy Wątek");
        new TworzenieWieluWatkow("Drugi Wątek");
        new TworzenieWieluWatkow("Trzeci Wątek");

        try
        {
            Thread.sleep(8000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Przerwano WĄTEK GŁÓWNY" + "\n" + e);
        }
        System.out.println("Koniec WĄTKU GŁÓWNEGO.");
    }
}
