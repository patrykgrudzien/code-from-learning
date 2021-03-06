package PrzydatneKlasy;

import GrafikaAWT_Swing.Colorable;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomTest implements Colorable
{
    public static void main(String[] args)
    {
        /**
         * Czasem zdarza nam się, że potrzebujemy, chociażby do przetestowania aplikacji,
         * pakietu liczb losowych. W takich momentach, z pomocą przychodzi nam klasa (Random)
         *
         * Można wygenerować sobie DOWOLNEGO TYPU liczby pseudolosowe z wybranych przez siebie zakresów.
         */

        DecimalFormat decimalFormat = new DecimalFormat("0.000");

        // double nextDouble() - - metoda zwraca nam losową liczbę z przedziału 0 - 1
        List<Double> list = new LinkedList<>();
        Random generator = new Random();

        for (int i = 0; i < 10; i++)
        {
            list.add(generator.nextDouble() * 10);
        }

        System.out.println(RED + "Metoda nextDouble():" + RESET);
        for (Double d : list)
        {
            System.out.println(decimalFormat.format(d));
        }


        /**
         * int nextInt()- metoda ta, różni się od powyższych zakresem i typem generowanych liczb.
         * Przy tej konkretnej metodzie, zakresem jest CAŁY zakres Integer ,a generowane liczby
         * są zarówno dodatnie, jak i ujemne.
         */
        List<Integer> list1 = new LinkedList<>();
        for (int i = 0; i < 10; i++)
        {
            list1.add(generator.nextInt() / 1000000);
        }

        System.out.println(RED + "Metoda nextInt():" + RESET);
        for (Integer i : list1)
        {
            System.out.println(i);
        }


        /**
         * int nextInt(int n) - to przeładowanie powyższej metody wprowadza górny (i dolny) ogranicznik.
         * Generuje liczby z zakresu od zera (a więc same dodatnie, w przeciwieństwie do wersji bezparametrycznej)
         * do wartości n, podanej jako parametr
         */
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < 10; i++)
        {
            list2.add(generator.nextInt(50));   // liczby z przedziału 0-49
        }

        System.out.println(RED + "Metoda nextInt(int n):" + RESET);
        for (Integer i : list2)
        {
            System.out.println(i);
        }
    }
}
