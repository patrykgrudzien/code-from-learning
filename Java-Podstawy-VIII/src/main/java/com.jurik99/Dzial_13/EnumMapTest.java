package Dzial_13;

import Cave_of_Programming.Collections.Colorable;

import java.util.EnumMap;

public class EnumMapTest implements Colorable
{
    enum Weekdays
    {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args)
    {
        EnumMap<Weekdays, Integer> days = new EnumMap<>(Weekdays.class);
        days.put(Weekdays.MONDAY, 1);
        days.put(Weekdays.TUESDAY, 2);
        days.put(Weekdays.WEDNESDAY, 3);
        days.put(Weekdays.THURSDAY, 4);
        days.put(Weekdays.FRIDAY, 5);
        days.put(Weekdays.SATURDAY, 6);
        days.put(Weekdays.SUNDAY, 7);

        for (EnumMap.Entry<Weekdays, Integer> x : days.entrySet())
        {
            Weekdays keys = x.getKey();
            Integer value = x.getValue();
            System.out.println(RED + "Klucz = " + RESET + keys + BLUE + " wartość: " + RESET + value);
        }
    }
}
