package ProgramowanieWielowatkowe;

public class Implementacja implements Runnable
{
    private Thread t;

    public Implementacja()
    {
        t = new Thread(this, "Nowy Wątek");
        System.out.println(t);
        t.start();
    }

    @Override
    public void run()
    {
        try
        {
            for (int i = 5; i >= 0 ; i--)
            {
                System.out.println("Nowy Wątek: " + i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Przerwanie działania Nowego Wątku!" + "\n" + e);
        }
        System.out.println("Nasz nowy wątek zakończył działanie :)");
    }
}

class Demo
{
    public static void main(String[] args)
    {
        new Implementacja();

        try
        {
            for (int i = 5; i >= 0; i--)
            {
                System.out.println("Wątek główny: " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Przerwano działanie Wątku Głównego!" + "\n" + e);
        }
        System.out.println("Koniec Wątku Głównego!");
    }
}
