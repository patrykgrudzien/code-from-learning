package com.jurik99;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings({"DanglingJavadoc", "SpellCheckingInspection"})
public class Main {

    public static void main(final String[] args) {

        System.out.println("10 == 10: " + (10 == 10));
        System.out.println("10 != 10: " + (10 != 10));
        System.out.println("true == true: " + (true == true));
        System.out.println("true != true: " + (true != true));
        System.out.println("'a' == 'a': " + ('a' == 'a'));
        System.out.println("'a' != 'a': " + ('a' != 'a'));
        System.out.println("500L == 500L: " + (500L == 500L));
        System.out.println("500L != 500L: " + (500L != 500L));

        /**
         * O ile sprawdzanie równości wartości liczb całkowitych nie jest trudne to ta sama operacja
         * dla typów zmiennoprzecinkowych jest trochę bardziej skomplikowana. W związku ze sposobem
         * reprezentacji liczb zmiennoprzecinkowych typu float i double w pamięci komputera nie jest
         * możliwe ich dokładne porównywanie. Operacja taka jest dopuszczalna ale może prowadzić do
         * dziwnych rezultatów (na przykład, liczby, które teoretycznie powinny być równe według komputera nie są).
         *
         * W związku z tym liczby zmiennoprzecinkowe powinno się porównywać z pewną dokładnością.
         */
        System.out.println("0.3 == 0.1 + 0.2: " + (0.3 == 0.1 + 0.2)); // !!!
        System.out.println("0.3 == 0.1 + 0.2: " + (Math.abs(0.3 - (0.1 + 0.2)) < 0.000001));


        System.out.println(StringUtils.repeat('-', 50));


        /**
         * === (POROWNYWANIE OBIEKTOW) ===
         *
         * Używając operatora == do porównywania obiektów uzyskamy błędne rezultaty.
         * Do porównania tego typu powinniśmy używać metody equals.
         */
        System.out.println("test == test: " + (new String("test") == new String("test")));
        System.out.println("test equals test: " + new String("test").equals(new String("test")));

        /**
         * Dlaczego tak się dzieje? Otóż w przypadku obiektów operator == porównuje referencje obiektów (adresy na stercie).
         * Mając dwie różne instancje obiektów mają one dwa różne adresy w pamięci w związku z tym zawsze ich adresy są różne.
         * Innymi słowy w przypadku obiektów przy pomocy operatora == możemy sprawdzić czy dwie referencje wskazują na ten sam obiekt.
         */
        final String reference1 = new String("something");
        final String reference2 = reference1;
        System.out.println("reference1 == reference2 = " + (reference1 == reference2));
    }
}
