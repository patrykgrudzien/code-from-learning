package Dzial_5;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class EqualsTest
{
    public static void main(String[] args)
    {
        Employee alice1 = new Employee("Alicja Adamczuk", 75000, 1987, 12, 15);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alicja Adamczuk", 75000, 1987, 12, 15);
        Employee bob = new Employee("Bartosz Borkowski", 5000, 1989, 10, 1);

        System.out.println("alice1 == alice2: " +(alice1==alice2));
        System.out.println("alice1 == alice3: " +(alice1==alice3));

        System.out.println("alice1.equals(alice3): " +alice1.equals(alice3));
        System.out.println("alice1.equals(bob): " +alice1.equals(bob));

        System.out.println("bob.toString(): " +bob);



        System.out.println();



        Manager carl = new Manager("Karol Krakowski", 8000, 1987, 12, 15);
        Manager boss = new Manager("Karol Krakowski", 8000, 1987, 12, 15);
        boss.setBonus(5000);

        System.out.println("boss.toString(): " +boss);
        System.out.println("carl.equals(boss): " +carl.equals(boss));

        System.out.println("alice1.hashCode(): " +alice1.hashCode());
        System.out.println("alice3.hashCode(): " +alice3.hashCode());
        System.out.println("bob.hashCode(): " +bob.hashCode());
        System.out.println("carl.hashCode(): " +carl.hashCode());
    }
}


class Employee
{
    private String name;
    private double salary;
    private Date hireday;

    public Employee(String name, double salary, int year, int month, int day)
    {
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
        hireday = calendar.getTime();
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public Date getHireday()
    {
        return hireday;
    }

    public void raiseSalary(int procent)
    {
        double raise = salary * (procent/100);
        salary += raise;
    }

    // ---- EQUALS ---- //
    public boolean equals(Object otherObject)
    {
        // Sprawdzenie czy obiekty są identyczne
        if (this == otherObject)
            return true;

        // Musi zwrócić FALSE, jeśli jawny parametr jest null
        if (otherObject == null)
            return false;

        // Jeśli klasy nie zgadzają się, nie mogą być jednakowe
        if (this.getClass() != otherObject.getClass())
            return false;

        // Teraz wiadomo, że otherObject jest typu Employee i nie jest null
        Employee other = (Employee) otherObject;

        // Sprawdzenie czy pola mają identyczne wartości
        return  Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireday, other.hireday);
    }


    // ---- HASHCODE ---- //
    public int hashCode()
    {
        return Objects.hash(name, salary, hireday);
    }


    // ---- TOSTRING ---- //
    public String toString()
    {
        return getClass().getName() +"[name= "+ name +", salary= "+ salary +", hireDay= "+ hireday;
    }
}


class Manager extends Employee
{
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day)
    {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary()
    {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus)
    {
        this.bonus = bonus;
    }


    // ---- EQUALS ---- //
    public boolean equals(Object otherObject)
    {
        if (!super.equals(otherObject))
            return false;

        Manager other = (Manager) otherObject;

        // Metoda super.equals określiła, że obiekty należą do tej samej klasy
        return bonus == other.bonus;
    }


    // ---- HASHCODE ---- //
    public int hashCode()
    {
        return super.hashCode() + 17 * new Double(bonus).hashCode();
    }


    // ---- TOSTRING ---- //
    public String toString()
    {
        return super.toString() + "[bonus= " +bonus+ "]";
    }
}
