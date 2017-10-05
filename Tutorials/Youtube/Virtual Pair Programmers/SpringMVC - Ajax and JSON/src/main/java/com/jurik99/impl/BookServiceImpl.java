package com.jurik99.impl;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.jurik99.model.Book;
import com.jurik99.service.BookService;

@Log4j
@Service
public class BookServiceImpl implements BookService {

	@Override
	public List<Book> searchBooksByLooseMath(final String chars) {
		List<Book> preparedList = new ArrayList<>();
		if (chars.length() == 0) {
			return preparedList;
		}
		preparedList = Book.prepareListOfBooks();
		final List<Book> sortedListOfBooks = new ArrayList<>();

		preparedList.stream()
		          .filter(book -> book.getTitle().toUpperCase().contains(chars.toUpperCase()))
		          .collect(Collectors.toList())
		          .forEach(sortedListOfBooks::add);

		sortedListOfBooks.sort(Comparator.comparing(Book::getTitle, String::compareTo));

		log.warn("List has been sorted successfully.");
		return sortedListOfBooks;
	}
}
