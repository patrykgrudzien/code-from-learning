package Dzial_13.ObiektyOpakowujace;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LekkieObiekty
{
    public static void main(String[] args)
    {
        /**
         * Lekkie obiekty opakowujące kolekcje
         */
        int k = 0;
        Integer[] karty = new Integer[10];
        for (int i = 0; i < karty.length; i++)
        {
            karty[i] =  ++k;
        }
        System.out.println(Arrays.toString(karty));
        List<Integer> kartyLista = Arrays.asList(karty);

        /*
        Metody add() i remove() zmieniają rozmiar "oryginalnej" tablicy i dlatego
        zgłaszany jest wyjątek UnsupportedOperationException

        kartyLista.add(10);
        kartyLista.add(20);
        kartyLista.add(30);
        kartyLista.add(40);

         */

        /**
         * Zwrócony obiekt nie jest typu "ArrayList".
         * Jest to obiekt widokowy udostępniający metody "get()" i "set()"
         */
        System.out.println("Metoda get(): " + kartyLista.get(1));


        // Od Java SE 5.0 metoda "asList()" może przyjmować różne zestawy argumentów
        List<String> names = Arrays.asList("Tomek", "Patryk", "Zuzia");
        System.out.println("Names: " + names);


        /**
         * Poniższa instrukcja zwraca niemodyfikowalny obiekt implementujący interfejs "List"
         * oraz tworzy złudzenie istnienia "n" elementów typu anObject
         * Collections.nCopies(n, anObject)
         */
        List<String> settings = Collections.nCopies(20, "DEFAULT");
        System.out.println("nCopies: " + settings);


        /**
         * Metoda wywołana poniżej zwraca obiekt widokowy implementujący interfejs "Set"
         * (w odróżnieniu od metody "nCopies", która tworzy listę).
         */
        Set<String> zbior = Collections.singleton("ELEMENT_ZBIORU");
        System.out.println("singleton: " + zbior);
    }
}
