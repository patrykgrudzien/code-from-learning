package Dzial_11;

import java.util.Scanner;

public class StackTraceTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj n: ");
        int n = in.nextInt();
        silnia(n);
    }

    /**
     * Oblicza silnię liczby
     * @param n nieujemna liczba całkowita
     * @return n! = 1*2*...*n
     */
    public static int silnia(int n)
    {
//        System.out.println("Silnia(" +n+ "):");
//        Throwable t = new Throwable();
//        StackTraceElement[] frames = t.getStackTrace();
//
//        for (StackTraceElement f : frames)
//        {
//            System.out.println(f);
//        }

        int r;

        if (n == 0)
        {
            r = 1;  // Przypadek podstawowy
        }
        else
        {
            r = n * silnia(n - 1);
        }

        System.out.println("Silnia z: " +n+ " wynosi: " +r);
        return r;
    }
}
