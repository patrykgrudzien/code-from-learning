package Dzial_13;

import java.util.HashMap;
import java.util.Map;

/**
 * Niniejszy program demonstruje użycie mapy z kluczami typu String i wartościami typy Employee
 */

public class MapTest
{
    public static void main(String[] args)
    {
        Map<String, Employee> staff = new HashMap<String, Employee>();

        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Harry Hacker"));
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("Francesca Cruz"));

        // WYDRUK WSZYSTKICH POZYCJI
        System.out.println(staff);


        // USUNIĘCIE WARTOŚCI
        staff.remove("567-24-2546");
        System.out.println(staff);


        // PODMIENIENIE POZYCJI
        staff.put("456-62-5527", new Employee("Francesca Miller"));
        System.out.println(staff);


        // WYSZUKANIE WARTOŚCI
        System.out.println(staff.get("157-62-7935"));


        // ITERACJA PRZEZ WSZYSTKIE POZYCJE
        for (Map.Entry<String, Employee> x : staff.entrySet())
        {
            String klucz = x.getKey();
            Employee wartosc = x.getValue();
            System.out.println("Klucz: " +klucz+ ", wartość: " +wartosc);
        }

    }
}

/**
 * Zminimalizowana klasa Employee do celów testowych
 */
class Employee
{
    private String name;
    private double salary;

    /**
     * Tworzy obiekt Employee z pensją w wysokości 0
     * @param name Imię pracownika
     */
    public Employee(String name)
    {
        this.name = name;
        salary = 0;
    }

    public String toString()
    {
        return "[Imię i nazwisko: " +name+ ", Pensja: " +salary+ "]";
    }
}
