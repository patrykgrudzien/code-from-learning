package ProgramowanieWielowatkowe;

public class Priorytety
{
    /*
    Priorytety watkow sa wykorzystywane przez algorytm harmonogramowania watkow, do wybrania
    nastepnego watku do uruchomienia

    Teoretycznie zaklada sie, ze watki o wyzszym priorytecie maja dostep do wiekszej ilosci czasu
    pracy procesora.

    Watek o wyzszym priorytecie moze przejac czas dany przez procesor od watku o nizszym
    priorytecie.
     */

    public static void main(String[] args)
    {
        Thread t = Thread.currentThread();
        System.out.println("Priorytet wątku głównego przed zmianą: " + t.getPriority());

        // Priorytet musi byc w zakresie od 1-10
        t.setPriority(3);
        System.out.println("Priorytet wątku głównego po zmianie: " + t.getPriority());

        // 3 stałe okreslajace zakres wartosci priorytetu (minimalny, normalny, maksymalny)
        t.setPriority(Thread.MIN_PRIORITY);
        System.out.println(t.getPriority());
        t.setPriority(Thread.NORM_PRIORITY);
        System.out.println(t.getPriority());
        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t.getPriority());

    }
}
