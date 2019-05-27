package Dzial_13.ObiektyOpakowujace;

import java.util.LinkedList;
import java.util.List;

public class WidokiPrzedzialowe
{
    public static void main(String[] args)
    {
        /**
         * Przedziały można tworzyć z kilku rodzajów kolekcji.
         */
        List<String> imiona = new LinkedList<String>();
        imiona.add("Patryk");
        imiona.add("Damian");
        imiona.add("Andrzej");
        imiona.add("Violetta");
        imiona.add("Patrycja");
        imiona.add("Staszek");
        imiona.add("Joanna");

        // Pierwszy indeks jest wliczany, drugi nie (podobnie jak z parametrami metody "substring()"
        List przedzial = imiona.subList(1, 4);
        System.out.println(przedzial);

        // Można usunąć cały przedział (rezultat będzie widoczny w całej liście)
        przedzial.clear();
        System.out.println(imiona);
    }
}
