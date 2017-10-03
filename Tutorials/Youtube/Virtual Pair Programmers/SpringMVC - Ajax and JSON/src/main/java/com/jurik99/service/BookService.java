package com.jurik99.service;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.jurik99.model.Book;

@Log4j
@Service
public class BookService {

	private List<Book> testBooksList = Book.prepateListOfBooks();

	public List<Book> searchBooksByLooseMath(final String chars) {
		log.warn("looking for " + chars);

		final List<Book> sortedListOfBooks = new ArrayList<>();

		testBooksList.stream()
		          .filter(book -> book.getTitle().toUpperCase().contains(chars.toUpperCase()))
		          .collect(Collectors.toList())
		          .forEach(sortedListOfBooks::add);

		sortedListOfBooks.sort(Comparator.comparing(Book::getTitle, String::compareTo));

		log.warn("List has been sorted successfully.");
		return sortedListOfBooks;
	}
}
