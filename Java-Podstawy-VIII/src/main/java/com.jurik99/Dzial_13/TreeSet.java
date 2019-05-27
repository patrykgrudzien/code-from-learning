package Dzial_13;

import java.util.SortedSet;

public class TreeSet
{
    public static void main(String[] args)
    {
        SortedSet<String> sortedSet = new java.util.TreeSet<String>();

        sortedSet.add("Patryk");
        sortedSet.add("Janek");
        sortedSet.add("Viola");
        sortedSet.add("Andrzej");

        System.out.println(sortedSet);

        for (String s : sortedSet)
        {
            System.out.println(s);
        }

    }
}
