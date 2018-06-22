package com.jurik99.main;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import com.jurik99.data.BookList;
import com.jurik99.model.Book;

public class BookMain {

	public static void main(final String[] args) {

		final BookList bookList = new BookList();

		bookList.insertBooksIntoList(15);
		final List<Book> listOfBooks = bookList.getListOfBooks();

		System.out.println("Prices: ");
		final List<Double> booksPrices = listOfBooks.stream().map(Book::getPrice).collect(Collectors.toList());
		booksPrices.forEach(System.out::println);

		System.out.println("\nMAX: ");
		final Optional<Book> bookOptional = listOfBooks.stream().max(Comparator.comparing(Book::getPrice));
		final Book book = bookOptional.orElseThrow(() -> new NoSuchElementException("NO ELEMENT LIKE THIS"));
		System.out.println(book);

		System.out.println("\nSorted books by title: ");
		final List<Book> booksOrderedByTitle = listOfBooks.stream()
		                                                  .sorted(Comparator.comparing(Book::getTitle, String::compareTo))
		                                                  .collect(Collectors.toList());
		booksOrderedByTitle.forEach(System.out::println);

		// --- Add to new List all books which prices are > 50 ---
		final List<Book> booksPriceGreaterThan50 = listOfBooks.stream().filter(book1 -> book1.getPrice() > 50)
		                                                      .sorted(Comparator.comparing(Book::getPrice, Double::compareTo))
		                                                      .collect(Collectors.toList());
		System.out.println("\nBooks more expensive than 50: ");
		booksPriceGreaterThan50.forEach(System.out::println);
	}
}
