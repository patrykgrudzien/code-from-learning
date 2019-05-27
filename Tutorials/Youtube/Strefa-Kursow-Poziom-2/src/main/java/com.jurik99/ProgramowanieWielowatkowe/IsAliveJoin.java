package ProgramowanieWielowatkowe;

public class IsAliveJoin
{
    /*
    Watek glowny powinien konczyc swoja prace jako ostatni z uwagi na jego funkcje czyszczace.
    Sa 2 sposoby na to aby okreslic czy dany watek zakonczyl swoje dzialanie.

    1) sposob polega na wywolaniu dla watku metody final boolean isAlive() - TRUE jesli watek
    pracuje i FALSE jezeli NIE pracuje

    Najczesciej uzywa sie 2) sposobu, ktorym jest metoda join(). Metoda ta czeka az watek dla
    ktorego zostala wywolana zakonczy swe dzialanie.
    final void join() throws InterruptedException
     */

    public static void main(String[] args)
    {
        TworzenieWieluWatkow w1 = new TworzenieWieluWatkow("Pierwszy Wątek");
        TworzenieWieluWatkow w2 = new TworzenieWieluWatkow("Drugi Wątek");
        TworzenieWieluWatkow w3 = new TworzenieWieluWatkow("Trzeci Wątek");

        System.out.println("Czy pierwszy wątek żyje? " +w1.t.isAlive());
        System.out.println("Czy drugi wątek żyje? " +w2.t.isAlive());
        System.out.println("Czy trzeci wątek żyje? " +w3.t.isAlive());

        try
        {
            System.out.println("Oczekiwanie na zakończenie wątków");
            w1.t.join();
            w2.t.join();
            w3.t.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Przerwano pracę wątku głównego!" + "\n" + e);
        }

        System.out.println("Czy pierwszy wątek żyje? " +w1.t.isAlive());
        System.out.println("Czy drugi wątek żyje? " +w2.t.isAlive());
        System.out.println("Czy trzeci wątek żyje? " +w3.t.isAlive());

        System.out.println("Koniec WĄTKU GŁÓWNEGO.");
    }
}
