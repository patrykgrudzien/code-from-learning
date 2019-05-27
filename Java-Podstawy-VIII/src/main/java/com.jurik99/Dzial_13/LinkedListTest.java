package Dzial_13;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest
{
    public static void main(String[] args)
    {
        List<String> a = new LinkedList<String>();
        a.add("Ania");
        a.add("Karol");
        a.add("Eryk");

        List<String> b = new LinkedList<String>();
        b.add("Bartek");
        b.add("Daniel");
        b.add("Franek");
        b.add("Gosia");

        // Scalenie list a i b
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext())
        {
            if (aIter.hasNext())
            {
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        System.out.println("a = " +a);


        // Usunięcie co drugiego słowa z listy b
        bIter = b.iterator();
        while (bIter.hasNext())
        {
            bIter.next();
            if (bIter.hasNext())
            {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println("b = " +b);


        // Usunięcie wszystkich słów znajdujących się w liście b z listy a
        a.removeAll(b);
        System.out.println("removeAll = " +a);



// --------------------------------------------------------------------------------------------------------------------- //


        // ----- WŁASNE TESTY ----- //
        System.out.println();
        List<String> lista = new LinkedList<String>();
        lista.add("Patryk");
        lista.add("Grudzień");
        System.out.println("Własna lista: " +lista);

        ListIterator<String> listaIterator = lista.listIterator();
        String oldValue = listaIterator.next();
        System.out.println("Old Value: " +oldValue);
        listaIterator.set("Damian");
        System.out.println("Lista po metodzie SET: " +lista);



        System.out.println();
        List<Integer> list1 = new LinkedList<Integer>();
        list1.add(100);
        list1.add(2445);
        list1.add(367);
        list1.add(4);
        list1.add(5);
        list1.add(6);

        ListIterator<Integer> i1 = list1.listIterator();
        ListIterator<Integer> i2 = list1.listIterator();
        System.out.println(list1);

//        i1.next();
//        i1.remove();
        // i2.next(); --> ConcurrentModificationException

        // INDEX
        System.out.println("i1.next(): "+i1.next());
        System.out.println("i1.next(): "+i1.next());

        System.out.println("nextIndex: " +i1.nextIndex());  // zwraca INDEKS a NIE WARTOSC całkowitoliczbowy elementu, który zostałby zwrócony przez następne wywołanie metody NEXT
        System.out.println("previousIndex: " +i1.previousIndex());
        System.out.println("Element po wywołaniu GET: " +list1.get(2)); // metoda GET zwraca ten sam wynik co metoda NEXT
        System.out.println("Previous: " +i1.previous());
    }
}
