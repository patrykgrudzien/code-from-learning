package com.jurik99.data;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jurik99.model.Book;

public class BookList {

	private List<Book> books = new ArrayList<>();
	private Random random = new Random();

	public void insertBooksIntoList(final int howManyBooks) {

		for (int i = 0; i < howManyBooks; i++) {

			final int id = random.nextInt(25);
			final String title = RandomStringUtils.randomAlphabetic(10);
			final double price = random.nextInt(100);

			books.add(new Book(id, title, price));
		}
	}

	public List<Book> getListOfBooks() {
		return books;
	}
}
