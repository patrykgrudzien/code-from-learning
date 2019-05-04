package com.jurik99;

@SuppressWarnings({"DanglingJavadoc", "SpellCheckingInspection"})
public class MetodaHashCode {

    public static void main(final String[] args) {

        /**
         * Podobnie jak w przypadku equals, hashCode jest zaimplementowane w klasie Object.
         * Zawsze kiedy programista implementuje metodę hashCode powinien też zaimplementować metodę equals.
         *
         * Metoda ta zwraca liczbę typu int, która służy do przyporządkowania danego obiektu do grupy.
         * Dzięki metodzie hashCode jesteśmy w stanie podzielić wszystkie możliwe instancje danej klasy
         * na rozdzielne grupy. Każda z tych grup reprezentowana jest przez liczbę zwracaną przez metodę hashCode.
         *
         * Obrazowe przyporządkowanie obiektów do grup zostało przedstawione na diagramie powyżej. Koła i trójkąt zostały przyporządkowane do tej samej grupy, rąb i pięciokąt do grupy Hash#2 natomiast trapez został przyporządkowany do grupy Hash#3.
         *
         *
         * Metoda hashCode wykorzystywana jest przez niektóre kolekcje (tablice na sterydach),
         * o których przeczytasz w jednym z kolejnych artykułów.
         * Implementacja metody hashCode sprowadza się do zwrócenia odpowiedniej liczby, tak zwanego hasha.
         * Przyporządkuje on dany obiekt do grupy używanej w niektórych kolekcjach.
         * Najczęściej metodę hashCode implementuje się w oparciu o hashe atrybutów danej instancji.
         * Hashe atrybutów zazwyczaj mnoży się przez liczby pierwsze i sumuje ze sobą. Użycie liczb pierwszych
         * pomaga w uzyskaniu “dobrych hashy”. Dobra implementacja hashCode pozwala na uzyskanie jak największej
         * liczby grup (hashy), do których przyporządkowujemy obiekty.
         *
         * === ( KONTRAKT POMIĘDZY METODAMI "equals()" i "hashCode()" ) ===
         * Metody hashCode() i equals() są ze sobą powiązane i ich implementacja powinna być spójna.
         * Tą zależność określa się KONTRAKTEM między metodami hashCode() i equals().
         *
         * 1) Jeśli X.equals(Y) == true - wówczas wymagane jest aby X.hashCode() == Y.hashCode()
         * 2) Kilkukrotne wywołanie metody hashCode na tym samym obiekcie,
         * który nie był modyfikowany pomiędzy wywołaniami musi zwrócić tę samą wartość
         * 3) Jeśli X.hashCode() == Y.hashCode() to nie jest wymagane aby X.equals(Y) == true.
         * Trzeci przypadek jest ilustrowany na obrazku powyżej gdzie koła i trójkąt mają ten sam hashCode
         * jednak koło i trójkąt nie są równe.
         */
    }
}
