package com.jurik99;

import java.util.Objects;

@SuppressWarnings({"SpellCheckingInspection", "DanglingJavadoc"})
public class MetodaEquals {

    public static void main(final String[] args) {

        /**
         * Metoda {@link Object#equals(Object)} jest jedną z metod dostępnych w klasie
         * {@link Object}. W związku z tym, że każdy objekt w języku Java ma tę klasę
         * w swojej hierarchii dziedziczenia możemy tą metodę wywołać na każdym obiekcie.
         *
         * W większości przypadków domyślna implementacja metody {@link Object#equals(Object)}
         * nie jest odpowiednia (domyślna implementacja zachowuje się jak operator ==,
         * porównuje adresy obiektów), w związku z tym programista tworzący nowy obiekt musi
         * tę metodę zaimplementować jeśli chce sprawdzać czy instancje tej klasy są równe.
         */
        final PersonWithEqualsAndHashCode person1 = new PersonWithEqualsAndHashCode("name1", 1);
        final PersonWithEqualsAndHashCode person2 = new PersonWithEqualsAndHashCode("name1", 1);
        System.out.println("person1 == person2 = " + (person1 == person2));
        System.out.println("person1.equals(person2) = " + person1.equals(person2)); // returns true

        final PersonRaw personRaw1 = new PersonRaw("name1", 1);
        final PersonRaw personRaw2 = new PersonRaw("name1", 1);
        System.out.println("personRaw1 == personRaw2 = " + (personRaw1 == personRaw2));
        System.out.println("personRaw1.equals(personRaw2) = " + personRaw1.equals(personRaw2)); // returns false

        /**
         * Istnieje zestaw wytycznych, które metoda equals powinna spełniać aby była poprawnie zaimplementowana.
         * Opiszę je po kolei:
         *
         * === (Metoda equals powinna być zwrotna) ===
         * Oznacza to tyle, że dla każdego obiektu operacja object.equals(object) powinna zwrócić true.
         *
         * === (Metoda equals powinna być symetryczna) ===
         * Oznacza to tyle, że dla każdej pary obiektów X i Y powinna zachodzić właściwość jeśli
         * X.equals(Y) == true wówczas także Y.equals(X) == true.
         *
         * === (Metoda equals powinna być przechodnia) ===
         * Jeśli mamy trzy obiekty X, Y i Z oraz jeśli
         * X.equals(Y) == true i
         * Y.equals(Z) == true
         * to także
         * X.equals(Z) jest prawdą.
         *
         * === (Metoda equals powinna być spójna) ===
         * Innymi słowy kilkukrotne wywołanie metody equals na tych samych obiektach zawsze powinno
         * zwrócić ten sam wynik (zakładając, że obiekty nie były modyfikowane pomiędzy wywołaniami).
         *
         * === (Metoda equals powinna zwrócić false przy porówaniu z null) ===
         * Dla każdego obiektu X, który nie jest null porównanie typu X.equals(null) powinno zwrócić false.
         */
    }
}

class PersonWithEqualsAndHashCode {

    private final String name;
    private final int age;

    PersonWithEqualsAndHashCode(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonWithEqualsAndHashCode)) return false;
        final PersonWithEqualsAndHashCode person = (PersonWithEqualsAndHashCode) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class PersonRaw {

    private final String name;
    private final int age;

    PersonRaw(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
