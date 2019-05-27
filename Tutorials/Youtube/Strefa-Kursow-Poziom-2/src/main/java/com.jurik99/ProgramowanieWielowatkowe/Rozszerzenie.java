package ProgramowanieWielowatkowe;

public class Rozszerzenie extends Thread
{
    Rozszerzenie()
    {
        super("Wątek klasy Rozszerzenie!");
        System.out.println("Nowy wątek." + this);
        start();
    }

    @Override
    public void run()
    {
        try
        {
            for (int i = 5; i >= 0 ; i--)
            {
                System.out.println(i);
                sleep(500);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Przerwanie działania Nowego Wątku!" + "\n" + e);
        }
        System.out.println("Nasz nowy wątek zakończył działanie :)");
    }
}
