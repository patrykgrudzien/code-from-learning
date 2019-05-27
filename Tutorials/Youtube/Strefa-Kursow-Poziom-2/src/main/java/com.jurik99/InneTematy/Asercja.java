package InneTematy;

public class Asercja
{
    /*
    Uzywa sie jej do sprawdzania i testowania roznych elementow aplikacji w procesie jej
    powstawania. Tym elementem moze byc np nasza metoda, ktora powinna zawsze zwracac wartosc
    dodatnia i chcemy sprawdzenia czy faktycznie zwraca wartosc dodatnia.

    Slowo kluczowe ASSERT, po ktorym dodajemy warunek do sprawdzenia. Warunkiem jest wyrazenie,
    ktore musi w wyniku dac wartosc typu prostego BOOLEAN.
    Jezeli asercja zwroci TRUE to program dziala bez problemow. Jezeli zwroci FALSE zglaszany
    jest wyjatek ASSERCION ERROR

    Domyslnie podczas uruchamiania naszego programu kompilator nie zwraca uwagi na slowo kluczowe
    ASSERT. Aby mechanizm asercji byl brany pod uwage musimy uruchomic nasz program z
    przedrostkiem -ea (java -ea Asercja)
     */

    static int val = 3;

    static int getNum() {return val--;}

    public static void main(String[] args)
    {
        int n;

        for (int i = 0; i < 10; i++)
        {
            n = getNum();

            assert n >= 0: "Osiągnięto wartość mniejszą od zera!";

            System.out.println("n wynosi: " + n);
        }
    }
}
