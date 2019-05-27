package ProgramowanieWielowatkowe.KomunikacjaMiedzywatkowa;

public class Sortownia
{
    /*
    W poprzednich przykladach stosujac slowo kluczowe SYNCHRONIZED zapewnialismy watkom pojedynczy
    dostep do wybranego obiektu.

    Choc korzystanie z niejawnych monitorow jest dosc uzyteczne to istnieje bardziej elegancki
    sposob sterowania dostepem.

    Sposob pozwalajacy zaoszczedzic marnotrawione cenne cykle naszych procesorow. Opiera sie on
    na KOMUNIKACJI MIEDZYPROCESOWEJ.

    Komunikacja miedzyprocesowa opiera sie na 3 finalnych metodach klasy OBJECT.
    wait()  notify()  notifyAll() - mozna je wywolac JEDYNIE w blokach SYNCHRONIZED

    Metoda wait() nakazuje watkowi, ktory ja wywolal aby wyszedl z monitora obiektu i zawiesil
    swoje dzialanie do momentu az inny watek wejdzie do tego monitora i wywola metode notify()
    Metoda notify() budzi watek, ktory wywolal metode wait() dla tego samego obiektu
    notifyAll() budzi wszystkie watki, ktore wywolaly metode wait() dla tego samego obiektu
    jednak tylko jeden z tych watkow uzyska dostep do obiektu

    FAŁSZYWE BUDZENIE
    */

    int n;
    boolean nowaPaczka = false;

    synchronized void nadaj(int n)
    {
        if (nowaPaczka)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                System.out.println("Złapano wyjątek w sortowni!");
            }
        }
        this.n = n;
        nowaPaczka = true;
        System.out.println("Nadano: " + n);
        // Ostatecznie budzę wątek klasy Odbiorca
        notify();
    }

    synchronized int odbierz()
    {
        if (!nowaPaczka)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                System.out.println("Złapano wyjątek w sortowni!");
            }
        }
        System.out.println("Odebrano: " + n);
        nowaPaczka = false;
        // Budzimy wątek nadawca
        notify();

        return n;
    }

}
