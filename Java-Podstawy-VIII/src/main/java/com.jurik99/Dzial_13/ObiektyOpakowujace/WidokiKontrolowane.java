package Dzial_13.ObiektyOpakowujace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class WidokiKontrolowane
{
    public static void main(String[] args)
    {
        List<String> strings = new ArrayList<String>();
        ArrayList rawList = (ArrayList) strings;
        rawList.add(new Date());    // błąd w instrukcji "add()" nie zostanie wykryty w czasie działania programu.
        // W zamian wystąpi wyjątek rzutowania, kiedy w innej części kodu zostanie wywołana metoda "get()" i zostanie
        // wykonane rzutowanie jej wyniku na typ STRING

        /**
         * Widok KONTROLOWANY wykryje taki błąd
         */
        List<String> safeStrings = Collections.checkedList(strings, String.class);
        ArrayList rawList2 = (ArrayList) safeStrings;
        rawList2.add(new Date());   // ClassCastException
    }
}
