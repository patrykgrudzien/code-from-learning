package Dzial_6;

import java.util.Arrays;

public class StaticInnerClassTest
{
    public static void main(String[] args)
    {
        int[] d = new int[20];

        for (int i = 0; i < d.length; i++)
        {
            d[i] = (int) (100 * Math.random());
        }
        System.out.println(Arrays.toString(d));
//        Arrays.sort(d);
//        System.out.println(Arrays.toString(d));
        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.println("Min = " +p.getFirst());
        System.out.println("Max = " +p.getSecond());
    }
}

class ArrayAlg
{
    public static class Pair
    {
        // --- KONSTRUKTOR --- //
        public Pair(double first, double second)
        {
            this.first = first;
            this.second = second;

        }

        public double getFirst()
        {
            return first;
        }

        public double getSecond()
        {
            return second;
        }

        // --- POLA --- //
        private double first;
        private double second;
    }

    // --- MIN / MAX --- //
    public static Pair minmax(int[] values)
    {
        int min = Integer.MAX_VALUE;    // 2147483647
        int max = Integer.MIN_VALUE;    // -2147483648
        for(int v:values)
        {
            if (v < min) min = v;
            if (v > max) max = v;
        }
        return new Pair(min, max);

    }
}
