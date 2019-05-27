package InneTematy;

public class Modyfikator_transient_volatile
{
    /*
    Modyfikator "transient" sprawia, ze wartosc zmiennej "a" NIE ZOSTANIE UTRWALONA przy zapisie
    obiektu na dysku, natomiast wartosc zmiennej "b" ZOSTANIE UTRWALONA na dysku

    Zagadnienie to pojawia sie szczegolnie w tematyce SERIALIZACJI bedacej procesem zapisywania
    biezacego stanu obiektu w strumieniu bajtow

    SERIALIZACJA pojawia sie w konteksie zdalnego wykonywania kodu znajdujacego sie na jednym
    komputerze z poziomu innego komputera
     */

    /*
    Modyfikator VOLATILE ma za zadanie informowac kompilator, iz oznaczona nim zmienna moze
    zostac nieoczekiwanie zmieniona przez inna czesc programu.
    Modyfikator ten stosuje sie przede wszystkim w srodowisku WIELOWATKOWYM gdzie czesto 2 lub
    wiecej watkow moze wspoldzielic ta sama zmienna skladowa

    Z uwagi na wydajnosc srodowiska JAVY w takiej sytuacji kazdy watek moze przechowywac wlasna
    kopie wspoldzielonej zmiennej skladowej. Niestety nie jest to zawsze rozwiazanie poprawne.
    Dzieki modyfikatorowi VOLATILE zmienna bedzie nieustannie posiadac aktualna wartosc. Jezeli
    trzeba to kompilator bedzie aktualizowac wartosc kopii wspoldzielonej zmiennej
     */

    transient int a;
    int b;
    volatile int c;
}
