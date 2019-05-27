package Dzial_13;

import java.util.*;
import java.util.TreeSet;

public class TreeSetTest
{
    public static void main(String[] args)
    {
        SortedSet<Item> parts = new TreeSet<Item>();
        parts.add(new Item("Toster", 1234));
        parts.add(new Item("Widget", 9912));
        parts.add(new Item("Modem", 2222));

        // Sortowanie wg numerów części (domyślny sposób)
        for (Item i : parts)
        {
            System.out.println(i);
        }


        System.out.println();


        // Sortowanie wg opisów (niestandardowy komparator)
        SortedSet<Item> sortByDescription = new TreeSet<Item>(new Comparator<Item>()
        {
            @Override
            public int compare(Item a, Item b)
            {
                String descrA = a.getDescription();
                String descrB = b.getDescription();
                return descrA.compareTo(descrB);
            }
        });
        sortByDescription.addAll(parts);
        for (Item item:sortByDescription)
        {
            System.out.println(item);
        }


        // API java.me.jurik99.util.SortedSet<E>
        System.out.println("\nMetoda first(): " +sortByDescription.first());
        System.out.println("Metoda last(): " +sortByDescription.last());

    }
}


/**
 * Obiekt posiadający opis i numer części
 */
class Item implements Comparable<Item>
{
    private String description;
    private int partNumber;

    /**
     * Tworzy obiekt item
     * @param description opis obiektu
     * @param partNumber numer części obiektu
     */
    public Item(String description, int partNumber)
    {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString()
    {
        return "[description: " +description+ ", partNumber: " +partNumber+ "]";
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (this == otherObject)
            return true;
        if (otherObject == null)
            return false;
        if (this.getClass() != otherObject.getClass())
            return false;

        Item other = (Item) otherObject;
        return description.equals(other.description) && partNumber == other.partNumber;
    }

    @Override
    public int hashCode()
    {
        return 13 * description.hashCode() + 17 * partNumber;
    }

    @Override
    public int compareTo(Item other)
    {
        return partNumber - other.partNumber;
    }
}