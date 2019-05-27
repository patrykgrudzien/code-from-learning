package com.jurik99;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target( {ElementType.METHOD, ElementType.FIELD} )
public @interface MyAnnotation
{
    /**
     * Adnotacjami nazywamy dodatkowe informacje (metadane) umieszczone w kodzie programu
     * źródłowego, które nie wpływają na działanie programu. Służą do opisywania: klas, metod,
     * pól itd...
     *
     * Możliwe wykorzystania:
     * 1) Meta programowanie
     * 2) Tworzenie własnych wskazówek
     * 3) Sterowanie komunikatami generowanymi przez kompilator
     * 4) Wiele innych
     *
     * Nazwa naszej własnej adnotacji poprzedzona jest słowem kluczowym "@interface".
     * Nasze adnotacje oparte są o mechanizm tworzenia interfejsów, ale dodatkowy przedrostek "@"
     * sygnalizuje kompilatorowi, że ma do czyniania z ADNOTACJAMI.
     *
     * ADNOTACJE NIE MOGĄ DZIEDZICZYĆ ale wszystkie ROZSZERZAJĄ interface Annotations.
     *
     * Deklarujemy tylko SYGNATURY METOD
     */

    // ------------------ STRATEGIE ZACHOWANIA ------------------ //
    /**
     * Możemy zażądać, aby nasza adnotacja cechowała się konkretnym zachowaniem.
     * Możliwe są 3 tryby:
     * 1) SOURCE - pomijana w trakcie kompilacji, występuje tylko w kodzie źródłowym
     * 2) CLASS - pomijana w trakcie kompilacji, dostępna również w pliku .class
     * 3) RUNTIME - pomijana w trakcie kompilacji, dostępna w pliku .class, możliwość korzystania
     * z adnotacji w czasie działania programu
     *
     * Aby wykorzystać wybraną strategię (wybrane zachowanie) przed deklaracją @interfejsu
     * piszemy słówko kluczowe "Retention" (retention z ang. - zachowanie)
     */

    // ------------------ DEFINIOWANIE ADNOTACJI ------------------ //
    String A();
    String B();
}
