package Dzial_6;

import java.util.Arrays;

public class EmployeeSortTest
{

    public static void main(String[] args) throws CloneNotSupportedException
    {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry", 35000);
        staff[1] = new Employee("Carl", 75000);
        staff[2] = new Employee("Tony", 38000);

        // ----- SORTOWANIE ----- //
        Arrays.sort(staff);

        for(Employee e:staff)
        {
            System.out.println("Name: " +e.getName()+ " , Salary: " +e.getSalary());
        }

        System.out.println();

        Employee original = new Employee("John", 5000);
        Employee copy = original;
        copy.raiseSalary(10);
        System.out.println("Original salary: " +original.getSalary());
        System.out.println("Copy salary: " +copy.getSalary());

        // ------------------------------------------------------------------------------------------------------
        System.out.println();
        // ------------------------------------------------------------------------------------------------------

        // ----- SKORZYSTAMY Z KOPIOWANIA OBIEKTOW ----- //
        Employee original2 = new Employee("John", 5000);
        Employee copy2 = original2.clone();
        copy2.raiseSalary(10);
        System.out.println("Original2 salary: " +original2.getSalary());
        System.out.println("Copy2 salary: " +copy2.getSalary());

    }

}

//----------------------------------------------------------
class Employee implements Comparable<Employee>, Cloneable
{
    // ----- KLONOWANIE PLYTKIE ----- //
    public Employee clone() throws CloneNotSupportedException
    {
        return (Employee) super.clone();	// ZWIEKSZENIE WIDOCZNOSCI I ZMIANA TYPU ZWROTNEGO
    }

    //----------------------------------------------------------
    private String name;
    private double salary;

    //----------------------------------------------------------
    public Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    //----------------------------------------------------------
    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    //----------------------------------------------------------
    public void raiseSalary(double procent)
    {
        double raise = salary * (procent/100);
        salary += raise;
    }

    //----------------------------------------------------------
    public int compareTo(Employee other)
    {
        if (salary > other.salary) return 1;
        if (salary < other.salary) return -1;
        return 0;
//        return name.compareTo(other.name);
    }

}