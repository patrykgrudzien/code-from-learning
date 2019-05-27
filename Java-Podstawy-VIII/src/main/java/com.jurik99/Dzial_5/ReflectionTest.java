package Dzial_5;

import java.util.*;
import java.lang.reflect.*;

public class ReflectionTest
{
    public static void main(String[] args)
    {
        /**
         * Wczytanie nazwy klasy z argumentów wiersza poleceń lub danych od użytkownika
         */
        String name;
        if (args.length > 0)
            name = args[0];
        else
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Podaj nazwę klasy (np. java.me.jurik99.util.Date): ");
            name = in.next();
        }


        // Drukowanie nazwy klasy i nadklasy (jeśli != Object)
        try
        {
            Class cl = Class.forName(name);
            Class superCl = cl.getSuperclass();
            String modifier = Modifier.toString(cl.getModifiers());

            if (modifier.length() > 0)
            {
                System.out.print(modifier +" ");
            }
            System.out.print("class " +name);

            if (superCl != null && superCl != Object.class)
            {
                System.out.print(" extends" + superCl.getName());
            }

            System.out.print("\n{\n");
            printConstructors(cl);

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        System.exit(0);

    }


    /**
     * Drukowanie wszystkich konstruktorów klasy.
     *
     * @param c klasa
     */
    public static void printConstructors(Class c)
    {
        Constructor[] constructors = c.getDeclaredConstructors();

        for (Constructor cons : constructors)
        {
            String name = cons.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(c.getModifiers());

            if (modifiers.length() > 0)
                System.out.print(modifiers+ " ");
            System.out.print(name + "(");

            // Drukowanie typów parametrów
            TypeVariable[] paramTypes = c.getTypeParameters();
            for (int i = 0; i < paramTypes.length; i++)
            {
                if (i>0)
                    System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(")");
        }
    }
}
