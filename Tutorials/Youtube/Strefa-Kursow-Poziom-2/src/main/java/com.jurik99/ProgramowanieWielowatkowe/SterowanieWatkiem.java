package ProgramowanieWielowatkowe;

public class SterowanieWatkiem
{
    public static void main(String[] args)
    {
        Thread t = Thread.currentThread();
        System.out.println("Aktualny watek: " + t);

        // Kilka przydatnych metod w zarzadzaniu watkami
        String threadName = t.getName();
        System.out.println("Nazwa watku przed zmiana: " + threadName);

        t.setName("JuRik99 Thread");
        System.out.println("Nazwa watku po zmianie: " + t.getName());

        try
        {
            for (int i = 5; i >= 0 ; i--)
            {
                System.out.println(i);
                t.sleep(2000);
            }
            System.out.println("KONIEC!");
        }
        catch (InterruptedException e)
        {
            System.out.println("Przerwanie watku glownego." + "\n" + e);
        }
    }
}
