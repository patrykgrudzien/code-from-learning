package com.jurik99;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatmapTest
{
	public static void main(String[] args)
	{
		List<Book> listBooks1 = Arrays.asList(
				new Book(39.99, "Czysty kod", "twarda", false),
				new Book(49.99, "Pani jeziora", "miękka", true),
				new Book(49.99, "Pani jeziora", "miękka", true),
				new Book(19.99, "PHP w akcji", "miękka", false),
				new Book(29.99, "Bajki", "twarda", true),
				new Book(19.99, "Żarty programistów", "miękka", true));

		/**
		 * Zajmijmy sie teraz metoda "flatMap()". Jak sama nazwa wskazuje, sluzy ona do splaszczania. Moze sie
		 * zdarzyc, ze przetwarzajac nasze obiekty, mozemy otrzymac taka konstrukcje:
		 * Stream<List<Book>>.
		 */

		// --- Tworze dodatkowa liste ksiazek ---
		List<Book> listBooks2 = Arrays.asList(
				new Book(39.99, "Czysty kod", "twarda", false),
				new Book(49.99, "Pani jeziora", "miękka", true),
				new Book(49.99, "Pani jeziora", "miękka", true));

		// --- Tworze liste list ---
		List<List<Book>> collectionOfListBooks = Arrays.asList(listBooks1, listBooks2);

		Stream<List<Book>> stream = collectionOfListBooks.stream();
		Stream<Book> bookStream1 = collectionOfListBooks.stream().flatMap(listOfBooks -> listOfBooks.stream());
		Stream<Book> bookStream2 = collectionOfListBooks.stream().flatMap(Collection::stream);
		List<Book> books = bookStream2.distinct().collect(Collectors.toList());
		books.forEach(book -> System.out.println(book.getTitle()));
	}
}
