package Dzial_12;

import java.util.ArrayList;
import Dzial_12.Pair;

public class Ograniczenia_Braki
{

// --------------------------------------------------------------------------------------------------

    /**
     * OBIEKTÓW KLASY UOGÓLNIONEJ NIE MOŻNA GENEROWAĆ ANI PRZECHWYTYWAĆ

 private class Problem<T> extends Exception
 {

 }

     */

// --------------------------------------------------------------------------------------------------

    /**
     * ZMIENNYCH TYPOWYCH NIE MOŻNA UŻYWAĆ W KLAUZULACH "CATCH"
     */

 public static <T extends Throwable> void doWork(Class<T> t)
 {
//     try
//     {
//
//     }
//     catch(T e)
//     {
//
//     }
 }

// --------------------------------------------------------------------------------------------------

    /**
     * MOŻNA NATOMIAST UŻYWAĆ ZMIENNYCH TYPOWYCH W SPECYFIKACJACH WYJĄTKÓW.
     */
    public static <T extends Throwable> void doWork(T t) throws T
    {
        try
        {

        }
        catch (Throwable realCause)
        {
            t.initCause(realCause);
            throw t;
        }
    }

    // --------------------------------------------------------------------------------------------------

    /**
     * NIE MOŻNA TWORZYĆ TABLIC TYPÓW UOGÓLNIONYCH.
     */
    public static void main(String[] args)
    {
       //   Pair<String>[] table = new Pair<String>[10];     ERROR
        ArrayList<Pair<String>> lista = new ArrayList<Pair<String>>();
    }
}