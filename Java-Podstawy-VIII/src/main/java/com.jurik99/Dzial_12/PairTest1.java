package Dzial_12;

import java.util.Arrays;

public class PairTest1
{
    public static void main(String[] args)
    {
        String[] words = {"zzz", "Ala", "ma", "kota", "i", "Aa", "psa", "Zapis", "alunia"};
        System.out.println(Arrays.toString(words));

        // --------------------------------------------------------------------------------------------- //
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("MIN: " +mm.getFirst());
        System.out.println("MAX: " +mm.getSecond());

        // --------------------------------------------------------------------------------------------- //
        Pair<String> words2 = ArrayAlg.getMiddle(words);
        System.out.println("Środkowy element to: " +words2.getFirst());

        // --------------------------------------------------------------------------------------------- //
        Integer[] numbers = {100,8,22,10,5,1};
        Pair<Integer> liczby = ArrayAlg.getMiddle(numbers);
        System.out.println("Środkowy element to: " +liczby.getFirst()+ " i " +liczby.getSecond());

        // --------------------------------------------------------------------------------------------- //
        System.out.println("Najmniejszy element tablicy to: " +ArrayAlg.min(numbers));

    }
}


class ArrayAlg
{
    /**
     * Pobiera najmniejszą i największą wartość z tablicy łańcuchów
     * @param a tablica łańcuchów
     * @return para złożona z najmniejszej i największej wartości lub null, jeśli talica "a" jest null bądź pusta
     */
    public static Pair<String> minmax(String[] a)
    {
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];

        for (int i = 0; i < a.length; i++)
        {
            // compareTo() zwraca UJEMNĄ LICZBĘ jeśli pierwszy łańcuch występuje przed drugim
            int result = min.compareTo(a[i]);
            int result2 = max.compareTo(a[i]);

            if (result > 0)
                min = a[i];
            if (result2 < 0)
                max = a[i];

//            if (min.compareTo(a[i]) > 0)
//                min = a[i];
//            if (max.compareTo(a[i]) < 0)
//                max = a[i];
        }
        return new Pair<String>(min, max);
    }

    // METODA UOGÓLNIONA
    public static <T> Pair<T> getMiddle(T[] array)
    {
        int arrayLength = array.length;
        if (arrayLength %2 == 0 )
        {
            T left = array[ (array.length/2)-1 ];
            T right = array[ (array.length/2) ];
            return new Pair<T>(left, right);
        }
        else
        {
            T center = array[array.length / 2];
            return new Pair<T>(center);
        }
    }


    // METODA UOGÓLNIONA
    public static <T extends Comparable> T min(T[] tab)
    {
        if (tab == null || tab.length == 0)
            return null;

        T smallest = tab[0];

        for (int i = 1; i < tab.length; i++)
        {
            if ( smallest.compareTo(tab[i]) > 0 )
                smallest = tab[i];
        }
        return smallest;
    }


}

/**
 * ZMIENNE TYPOWE UŻYWANE W DEFINICJI KLASY OKREŚLAJĄ TYPY ZWROTNE
 * METOD ORAZ TYPY PÓL I ZMIENNYCH LOKALNYCH
 */
class Pair<T>
{
    private T first;
    private T second;

    public Pair()
    {
        first = null;
        second = null;
    }

    public Pair(T first)
    {
        this.first = first;
    }

    public Pair(T first, T second)
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

    public void setFirst(T first)
    {
        this.first = first;
    }

    public void setSecond(T second)
    {
        this.second = second;
    }

}
