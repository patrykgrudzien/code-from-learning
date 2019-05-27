package ProgramowanieWielowatkowe;

public class SlowemWstepu
{
    /*
    Każda uruchamiana aplikacja tworzy tzw. proces w systemie operacyjnym.
    Wykonywaniem zadan tego procesu zajmuja sie w JAVIE wlasnie watki.
    Watek to sekwencja pewnych dzialan zapisana w programie.
     */

    /*
    class THREAD extends Object implements Runnable
    Klasa THREAD hermetyzuje watek przez co zeby odczytac jego stan musimy skorzystac z nowego
    egzemplarza tej klasy
     */

    /*
    Kazdy program zawiera WATEK GLOWNY.
    Od watku glownego zaczynaja swoj zywot wszystkie inne watki. Watek glowny konczy prace jako
    ostatni ze wzgledu na przeprowadzanie pewnych operacji czyszczacych.

    Watek glowny powstaje przy uruchamianiu programiu zawierajacego metode MAIN.
    Jest on odpalany przez wirtualna maszyne javy (JVM)

    Mamy dostep do informacji o nim oraz mozemy nim sterowac z pomoca egzemplarza klasy THREAD.
    currentThread()
     */


    // Napiszemy program pobierajacy oraz wyswietlajacy w konsoli info na temat watku glownego
    public static void main(String[] args)
    {
        Thread t = Thread.currentThread();
        System.out.println("Aktualny wątek: " + t);
        /*
        Thread[main,5,main]
        main - nazwa watku
        5 - liczbowy priorytet
        main - nazwa grupy do ktorej nasz watek nalezy
        Grupa watkow - struktura danych, ktora steruje w sposob ogolny stanem zbioru watkow
        */
    }
}
