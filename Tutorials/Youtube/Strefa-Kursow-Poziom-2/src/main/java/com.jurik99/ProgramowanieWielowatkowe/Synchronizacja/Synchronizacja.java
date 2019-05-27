package ProgramowanieWielowatkowe.Synchronizacja;

public class Synchronizacja
{
    /*
    Dzialajace rownolegle watki moga wspoldzielic zasoby. Taka sytuacja moze rodzic jednak pewne
    problemy, gdy owe watki odwoluja sie do jakies metody tego samego obiektu. Aby uniknac
    jednoczesnego dzialania watkow z tym samym obiektem korzysta się z tzw. SYNCHRONIZACJI.

    Gdy watek uzyska dostep do jakies metody to mowi sie, ze watek wszedl do MONITORA.
    MONITOR jest NIEJAWNYM obiektem, ktory posiadaja wszystkie inne obiekty w Javie.
    Gdy znajduje sie w nim juz jakis watek to zaklada blokade nie pozwalajaca na korzystanie z
    obiektu innym watkom.
    Te watki wiec musza poczekac az poprzedni watek wyjdzie z monitora.

    Synchronizacja kodu moze odbywac sie na 2 sposoby. Oba wymagaja slowa kluczowego SYNCHRONIZED.
    */

    public static void main(String[] args)
    {
        Klasa_A system = new Klasa_A();
        Klasa_B w1 = new Klasa_B(system, "Systemy Podtrzymywania Życia");
        Klasa_B w2 = new Klasa_B(system, "Systemy Stucznej Inteligencji");
        Klasa_B w3 = new Klasa_B(system, "Systemy Napędu Nadświetlnego");

        try
        {
            w1.t.join();
            w2.t.join();
            w3.t.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Przerwano Wątek Głowny..." + "\n" + e);
        }
    }
}


/**
Klasa A bedzie zawierala kod metody odpowiedzialnej za wyswietlanie przeslanego do niej tekstu
*/
class Klasa_A
{
    void sprawdz(String info)
    {
        System.out.print("[" + info + "]");
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Przerwano pracę wątku" + "\n" + e);
        }
        System.out.println(" <-- GOTOWE");
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Przerwano pracę wątku" + "\n" + e);
        }
    }
}


/**
Klasa B bedzie klasa definiujaca nasze dodatkowe watki
*/
class Klasa_B implements Runnable
{
    final Klasa_A system;
    String info;
    Thread t;

    public Klasa_B(Klasa_A sys, String str)
    {
        system = sys;
        info = str;
        t = new Thread(this);
        t.start();
    }

    public void run()
    {
        synchronized (system) // dzieki temu wywolania metod dla tego obiektu beda synchronizowane
        {
            system.sprawdz(info);
        }
    }
}
