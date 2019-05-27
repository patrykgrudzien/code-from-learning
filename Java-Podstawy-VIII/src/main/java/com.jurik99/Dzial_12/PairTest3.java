package Dzial_12;

import java.util.Date;
import java.util.GregorianCalendar;

public class PairTest3
{
    public static void main(String[] args)
    {
        Manager ceo = new Manager("Stanisław Skąpy", 800000, 2003, 12, 15);
        Manager cfo = new Manager("Piotr Podstępny", 0, 2003, 12, 15);
        Pair<Manager> buddies = new Pair<Manager>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(0);
        Manager[] managers = {ceo, cfo};

        System.out.println("Kasa " +ceo.getName()+ " wynosi: " +(ceo.getSalary() + ceo.getBonus()));
        System.out.println("Kasa " +cfo.getName()+ " wynosi: " +(cfo.getSalary() + cfo.getBonus()));

        Pair<Employee> result = new Pair<Employee>();

        minmaxBonus(managers, result);
        System.out.println("\nMIN i MAX: ");
        System.out.println("First: " +result.getFirst().getName()+ ", second: " +result.getSecond().getName());

        maxminBonus(managers, result);
        System.out.println("\nMAX i MIN: ");
        System.out.println("First: " +result.getFirst().getName()+ ", second: " +result.getSecond().getName());


        // hasNulls ?
        System.out.println("\nCzy któryś pracownik nie istnieje? --> " +PairAlg.hasNulls(buddies));

        // isZeroSalaryAndBonus ?
        System.out.println("\nCzy " +ceo.getName()+ " jest spłukany? --> " +PairAlg.isZeroSalaryAndBonus(ceo));
        System.out.println("Czy " +cfo.getName()+ " jest spłukany? --> " +PairAlg.isZeroSalaryAndBonus(cfo));
    }


    public static void printBuddies(Pair<? extends Employee> p)
    {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() +" i "+ second.getName() +" są kumplami.");
    }


    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result)
    {
        if (a == null || a.length == 0)
            return;

        Manager min = a[0];
        Manager max = a[0];

        for (int i = 1; i < a.length; i++)
        {
            if (min.getBonus() > a[i].getBonus())
                min = a[i];
            if (max.getBonus() < a[i].getBonus())
                max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }


    public static void maxminBonus(Manager[] a, Pair<? super Manager> result)
    {
        minmaxBonus(a, result);
        PairAlg.swapHelper(result);
    }
}


/**
 * --------------------------------------------------------------
 */
class PairAlg
{
    public static boolean hasNulls(Pair<?> p)
    {
        return p.getFirst() == null || p.getSecond() == null;   // return TRUE IF ( p.getFirst() == null || p.getSecond() == null )
    }

    public static boolean isZeroSalaryAndBonus(Manager e)
    {
        return e.getSalary() + e.getBonus() == 0;
    }

    public static <T> void swapHelper(Pair<T> p)
    {
        T second = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(second);
    }

    public static void swap(Pair<?> p)
    {
        swapHelper(p);
    }
}


/**
 * --------------------------------------------------------------
 */
class Employee
{
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary, int year, int month, int day)
    {
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
        hireDay = calendar.getTime();
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public Date getHireDay()
    {
        return hireDay;
    }

    public void raiseSalary(double procent)
    {
        double raise = salary * (procent/100);
        salary += raise;
    }
}


/**
 * --------------------------------------------------------------
 */
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

    public double getBonus()
    {
        return bonus;
    }
}