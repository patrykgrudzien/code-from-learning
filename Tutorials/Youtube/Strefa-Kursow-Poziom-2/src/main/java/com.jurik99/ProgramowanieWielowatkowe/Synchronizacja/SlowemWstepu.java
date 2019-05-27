package ProgramowanieWielowatkowe.Synchronizacja;

public class SlowemWstepu
{
    /*
    W Javie istnieja 2 sposoby synchronizacji.
    1) Uzycie slowa kluczowego SYNCHRONIZED bezposrednio przy definicji metody, do ktorej chcemy
       kolejkowac dostep. Jednak choc jest to sposob wyjatkowo latwy, wydajny i calkiem intuicyjny
       to nie zawsze mamy mozliwosc korzystania z niego i nie zawsze jest to sposob prawde
       powiedziawszy najbardziej odpowiedni.
       Wyobrazmy sobie sytuacje, gdy np kupujemy kod od Firmy X i nie mamy do niego bezposredniego
       dostepu.

    Co zrobic zaby zapewnic synchronizacje dostepu do obiektow klasy, ktora nie byla tworzona z
    mysla o dostepie wielowatkowym?
    Wystarczy umiescic wywolania metod, ktore chcemy synchronizowac w bloku SYNCHRONIZED.


    synchronized (obiekt - jest referencja do synchronizowanego obiektu)
    {
        synchronizowane instrukcje
    }
    */
}
