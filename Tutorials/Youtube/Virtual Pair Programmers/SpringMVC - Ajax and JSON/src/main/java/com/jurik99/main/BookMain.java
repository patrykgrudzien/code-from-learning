package com.jurik99.main;

import java.util.List;

import com.jurik99.impl.BookServiceImpl;
import com.jurik99.model.Book;
import com.jurik99.service.BookService;

public class BookMain {

	public static void main(final String[] args) {

		final BookService bookService = new BookServiceImpl();

		final List<Book> sortedList = bookService.searchBooksByLooseMath("pan");
		sortedList.forEach(System.out::println);
	}
}
