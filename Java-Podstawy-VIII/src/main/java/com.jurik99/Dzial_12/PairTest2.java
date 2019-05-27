package Dzial_12;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PairTest2
{
    public static void main(String[] args)
    {
        Integer[] tab = {1, 3, 99, 10};
        System.out.println(Array.minmax(tab));

        GregorianCalendar[] birthdays =
                {
                  new GregorianCalendar(1906, Calendar.DECEMBER, 9),
                  new GregorianCalendar(1815, Calendar.DECEMBER, 10),
                  new GregorianCalendar(1903, Calendar.DECEMBER, 3),
                  new GregorianCalendar(1910, Calendar.JUNE, 22)
                };

        Pair2<GregorianCalendar> tab2 = Array.minmax(birthdays);
        System.out.println("MIN = " +tab2.getFirst().getTime());
        System.out.println("MAX = " +tab2.getSecond().getTime());
    }
}


class Array
{
    /**
     * Pobiera najmniejszą i największą wartość z tablicy obiektów typu T
     * @param tablica tablica obiektów typu T
     * @return para złożona z najmniejszej i największej wartości lub wartość null, jeżeli
     * tablica jest null bądź pusta
     */
    public static <T extends Comparable> Pair2<T> minmax(T[] tablica)
    {
        if (tablica == null || tablica.length == 0) return null;

        T min = tablica[0];
        T max = tablica[0];

        for (int i = 1; i < tablica.length; i++)
        {
            int result = min.compareTo(tablica[i]);
            int result2 = max.compareTo(tablica[i]);

            // {10, 5, 2, 88, 60}
            if (result > 0)
                min = tablica[i];
            if (result2 < 0)
                max = tablica[i];
        }
        return new Pair2<T>(min, max);
    }
}


class Pair2<T>
{
    private T first;
    private T second;

    public Pair2()
    {
        first = null;
        second = null;
    }

    public Pair2(T first, T second)
    {
        this.first = first;
        this.second = second;
    }

    public T getFirst()
    {
        return first;
    }

    public T getSecond()
    {
        return second;
    }

    @Override
    public String toString()
    {
        return new String("MIN = " +getFirst()+ "\nMAX = " +getSecond());
    }
}
