package com.jurik99;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@SuppressWarnings({"SpellCheckingInspection", "DanglingJavadoc"})
public class Main {

    public static void main(final String[] args) throws FileNotFoundException {

        /**
         * (KLASY DO OBSŁUGI OPERACJI NA PLIKACH)
         *
         * Musisz wiedzieć, że klasy z biblioteki standardowej do obsługi plików wprowadzają pewne warstwy abstrakcji
         * ułatwiające pracę z plikami. Wygląda to w ten sposób, że mamy klasę X, która jest klasą podstawową
         * udostępniającą bardzo ograniczony zakres operacji. Klasa Y używając interfejsu klasy X udostępnia interfejs wyższego poziomu,
         * z którym programiście łatwiej jest pracować. Takie podejście można porównać do swego rodzaju cebuli ;)
         * gdzie każda kolejna warstwa bazuje na poprzedniej i udostępnia trochę inny interfejs.
         *
         * Przekładając to na konkretny przykład klas ze standardowej biblioteki Javy mamy klasę
         * ---- {@link java.io.File}, która oferuje podstawowe operacje na pliku.
         * Instancja File jest przyjmowana jako parametr do utworzenia instancji klasy
         * ---- {@link java.io.FileReader}, która pozwala programiście na tekstowy dostęp do pliku znak po znaku.
         * Z racji tego, że taka forma może być uciążliwa mamy do dyspozycji kolejną klasę
         * ---- {@link java.io.BufferedReader}, która pozwala na dostęp do pliku linijka po linijce.
         */
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("./test.txt")));

        /**
         * Z racji tego, że powyższy fragment jest dość długi i byłby uciążliwy do pisania za każdym razem
         * twórcy biblioteki przygotowali zestaw konstruktorów, które umożliwiają skrócenie tego zapisu.
         * W przykładzie poniżej programista nie tworzy wprost instancji klasy File, podaje jedynie ścieżkę do pliku.
         * Ta instancja tworzona jest za nas wewnątrz konstruktora klasy FileReader.
         */
        final BufferedReader bufferedReader1 = new BufferedReader(new FileReader("./test-1.txt"));

        /**
         * W artykule tym zajmowali będziemy się wyłącznie sekwencyjnym dostępem do plików.
         * Oznacza to, że pisząc do pliku zawsze dopisujemy linijkę na koniec a czytając, czytamy od początku pliku.
         * Oczywiście możemy też czytać z pliku/pisać do pliku w sposób losowy, wybierając dowolną lokalizację.
         * Takie podejście często jest wykorzystywane w przypadku plików binarnych, których strukturę doskonale znamy i wiemy,
         * że na przykład od bajtu 10 do bajtu 13 włącznie w pliku zawsze znajduje się liczba, która reprezentuje datę urodzenia.
         */
    }
}
