package Dzial_5;

import java.util.Calendar;
import java.util.Date;

public class Refleksja
{
    public static void main(String[] args)
    {
        Employee2 e = new Employee2("Patryk Grudzień", 5000, 2010, Calendar.MARCH, 20);

        Class cl = e.getClass();
        System.out.println(cl);

        System.out.println(e.getClass().getName() + " " + e.getName());


        // ------------------------- //
        Date d = new Date();
        Class cl2 = d.getClass();
        String name = cl2.getName();
        System.out.println(name);


        // ---- Obiekt klasy "Class" odpowiadający nazwie wybranej klasy można utworzyć za pomocą statycznej metody "forName" ---- //
        // ---- forName - zwraca obiekt klasy Class reprezentujący klasę o nazwie className ---- //
        String className = "java.me.jurik99.util.Date";
        try
        {
            Class cl3 = Class.forName(className);
            System.out.println(cl3.getName());
        }
        catch (ClassNotFoundException e1)
        {
            e1.printStackTrace();
        }


        // ---- Kolejna metoda tworzenia obiektu klasy "Class" ---- //
        Class c1 = Date.class;
        Class c2 = int.class;
        Class c3 = Double[].class;


        // ---- Tworzenie w locie egzemplarzy klas ---- //
        try
        {
            e.getClass().newInstance();
        }
        catch (InstantiationException e1)
        {
            e1.printStackTrace();
        }
        catch (IllegalAccessException e1)
        {
            e1.printStackTrace();
        }



    }
}
