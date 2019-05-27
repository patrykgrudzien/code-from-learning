package Dzial_13;

import Cave_of_Programming.Collections.Colorable;
import java.util.EnumSet;

public class EnumSetTest implements Colorable
{
    enum Weekday
    {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args)
    {
        // Metoda "allOf()" - zwraca zbiór zapełniony wartościami z określonego typu wyliczeniowego
        EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
        System.out.println(RED + "allOf(): " + RESET + always);


        // Metoda "noneOf()" - zwraca pusty zbiór pozwalający przechowywać wartości określonego typu wyliczeniowego
        EnumSet<Weekday> never = EnumSet.noneOf(Weekday.class);
        System.out.println(RED + "noneOf(): " + RESET + never);


        // Metoda "range()" - zwraca zbiór zapełniony wartościami z zakresu od "from" do "to" włącznie
        EnumSet<Weekday> workDay = EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);
        System.out.println(RED + "range(): " + RESET + workDay);


        // Metoda "of()" - zwraca zbiór zawierający określone wartości
        EnumSet<Weekday> mwf = EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        System.out.println(RED + "of(): " + RESET + mwf);
    }
}
