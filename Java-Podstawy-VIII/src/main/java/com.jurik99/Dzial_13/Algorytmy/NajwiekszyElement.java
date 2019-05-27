package Dzial_13.Algorytmy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class NajwiekszyElement
{
    public static void main(String[] args)
    {
        Integer[] tablica = {10, 6, 0, 15, 29, -5, 1};
        znajdzMax(tablica);


        ArrayList<Integer> liczby = new ArrayList<Integer>();
        liczby.add(2);
        liczby.add(10);
        liczby.add(15);
        liczby.add(-1);
        liczby.add(199);
        liczby.add(52);
        znajdzMaxListy(liczby);


        LinkedList<Integer> liczbyPowiazane = new LinkedList<Integer>();
        liczbyPowiazane.add(100);
        liczbyPowiazane.add(20);
        liczbyPowiazane.add(-50);
        liczbyPowiazane.add(0);
        liczbyPowiazane.add(872);
        liczbyPowiazane.add(45);
        znajdzMaxListaPowiazana(liczbyPowiazane);

        System.out.println();

        MaxUogolniony(liczby);
        MaxUogolniony(liczbyPowiazane);

        System.out.println();

        MinUogolniony(liczby);
        MinUogolniony(liczbyPowiazane);
    }



    // ----- MAX w TABLICY ----- //
    public static <T extends Comparable> void znajdzMax(T[] tablica)
    {
        if (tablica.length == 0)
            throw new NoSuchElementException("Rozmiar tablicy jest równy zero!");

        T largest = tablica[0];

        for (int i = 1; i < tablica.length; i++)
        {
            if (largest.compareTo(tablica[i]) < 0)
                largest = tablica[i];
        }
        System.out.println("MAX wartość w tablicy = " +largest);
    }



    // ----- MAX w LIŚCIE TABLICOWEJ ----- //
    public static <T extends Comparable> void znajdzMaxListy(ArrayList<T> lista)
    {
        if (lista.size() == 0)
            throw new NoSuchElementException("Rozmiar ArrayList jest równy zero!");

        T largest = lista.get(0);

        for (int i = 1; i < lista.size(); i++)
        {
            if (largest.compareTo(lista.get(i)) < 0)
                largest = lista.get(i);
        }
        System.out.println("MAX wartość w ArrayList = " +largest);
    }



    // ----- MAX w LIŚCIE POWIĄZANEJ ----- //
    public static <T extends Comparable> void znajdzMaxListaPowiazana(LinkedList<T> liczbyPowiazane)
    {
        if (liczbyPowiazane.isEmpty())
            throw new NoSuchElementException("Rozmiar LinkedList jest równy zero!");

        Iterator<T> iterator = liczbyPowiazane.iterator();
        T largest = iterator.next();

        while (iterator.hasNext())
        {
            T next = iterator.next();
            if (largest.compareTo(next) < 0)
                largest = next;
        }
        System.out.println("MAX wartość w LinkedList = " +largest);
    }


    /**
     * Największy element można znaleźć za pomocą prostej iteracji po elementach.
     * Dlatego metodę MAX można zaimplementować w taki sposób, aby przyjmowała
     * KAŻDY obiekt implementujący interfejs COLLECTION.
     */
    public static <T extends Comparable> void MaxUogolniony(Collection<T> collection)
    {
        if (collection.isEmpty())
            throw new NoSuchElementException("Kolekcja jest pusta!");

        Iterator<T> iterator = collection.iterator();
        T largest = iterator.next();

        while (iterator.hasNext())
        {
            T next = iterator.next();
            if (largest.compareTo(next) < 0)
                largest = next;
        }
        System.out.println("Największy element kolekcji = " + largest);
    }



    public static <T extends Comparable> void MinUogolniony(Collection<T> collection)
    {
        if (collection.isEmpty())
            throw new NoSuchElementException("Kolekcja jest pusta!");

        Iterator<T> iterator = collection.iterator();
        T smallest = iterator.next();

        while (iterator.hasNext())
        {
            T next = iterator.next();
            if (smallest.compareTo(next) > 0)
                smallest = next;
        }
        System.out.println("Najmniejszy element kolekcji = " + smallest);
    }

}