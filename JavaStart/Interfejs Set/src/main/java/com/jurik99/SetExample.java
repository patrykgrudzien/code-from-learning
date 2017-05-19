package com.jurik99;

import java.util.Set;
import java.util.TreeSet;

public class SetExample
{
	/*
	 * Jako przykład napiszmy program, w którym stworzymy zbiór typu "TreeSet" (posortowany) z imionami. Spróbujmy
	 * dodać kilka duplikatów, a następnie wyświetlmy wynik działania kilku metod.
	 */
	public static void main(final String[] args)
	{
		final Set<String> names = new TreeSet<>();
		names.add("Kasia");
		names.add("Ania");
		names.add("Ania");
		names.add("Wojtek");
		names.add("Zuza");
		names.add("Zuza");

		final int setSize = names.size();
		System.out.println("Number of names: " + setSize);

		final boolean isThereAnia = names.contains("Ania");
		System.out.println("Is Ania in this set? " + isThereAnia);

		for (final String name : names)
		{
			System.out.println(name);
		}

		/*
		 * Stworzyliśmy zbiór typu "TreeSet" i przypisaliśmy go do zmiennej typu "Set". W przypadku wszystkich
		 * rodzajów kolekcji dobrze jest sie posługiwać referencją ogólnego typu, ponieważ możemy w takiej sytuacji
		 * podmienić "TreeSet" na np. "LinkedHashSet" w dowolnym momencie, bez konieczności zmiany reszty kodu, jest
		 * to oczywiście zasługa "polimorfizmu".
		 *
		 * Do zbioru próbujemy dodać kilka imion w tym duplikaty "Ani" oraz "Zuzy". Ponieważ, zbiór oczekuje
		 * elementów unikalnych, to wystąpią one raz. Dodatkowo przy wyświetlaniu zauważmy, że elementy są
		 * posortowane, ponieważ klasa String implementuje interfejs COMPARABLE !!!
		 */
	}
}
