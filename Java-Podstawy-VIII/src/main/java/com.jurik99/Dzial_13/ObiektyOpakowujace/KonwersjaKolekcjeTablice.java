package Dzial_13.ObiektyOpakowujace;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KonwersjaKolekcjeTablice
{
    public static void main(String[] args)
    {
        // Konwersja tablicy na kolekcję
        String[] values = {"Patryk", "Damian"};
        Set<String> staff = new HashSet<String>(Arrays.asList(values));


        /**
         * Utworzenie tablicy z kolekcji NIE JEST JUŻ TAKIE ŁATWE
         *
         * Utworzy się tablica obiektów typu "OBJECT", którego nie można zmienić
         */
        Object[] tablica = staff.toArray();


        /**
         * W zamian należy użyć alternatywnej wersji niniejszej metody
         *
         * Przekazujemy do niej jako parametr tablicę o długości 0 takiego typu jaki potrzebujemy
         */
        String[] tablica2 = staff.toArray(new String[0]);


        /**
         * W razie potrzeby możemy utworzyć tablicę o odpowiednim rozmiarze
         */
        String[] tablica3 = staff.toArray(new String[staff.size()]);
    }
}
