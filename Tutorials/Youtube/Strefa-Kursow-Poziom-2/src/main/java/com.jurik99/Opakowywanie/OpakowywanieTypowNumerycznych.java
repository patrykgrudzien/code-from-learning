package Opakowywanie;

public class OpakowywanieTypowNumerycznych
{
    /*
    Wszystkie klasy opakowujace typy proste dziedzicza po klasie NUMBER
     */

    public static void main(String[] args)
    {
        Integer liczba = new Integer("10");
        int i = liczba;

        System.out.println(liczba);
        System.out.println(i);

    }
}
