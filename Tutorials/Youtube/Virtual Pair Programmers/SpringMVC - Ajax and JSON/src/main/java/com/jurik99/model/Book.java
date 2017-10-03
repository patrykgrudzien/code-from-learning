package com.jurik99.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "title"})
public class Book {

	private final int id;
	private final String title;
	private double price;
	private static List<Book> testBooksList;

	public static List<Book> prepateListOfBooks() {
		testBooksList = Arrays.asList(
				new Book(1, "Ogniem i mieczem"),
				new Book(2, "Pan Tadeusz"),
				new Book(3, "Chłopcy z placu broni"),
				new Book(4, "Pies który jeździł koleją"),
				new Book(5, "Latarnik"),
				new Book(6, "Przepisy kulinarne"),
				new Book(7, "Java Podstawy"),
				new Book(8, "Podstawy C#"),
				new Book(9, "Ruby w pigułce"),
				new Book(10, "Spring w akcji")
		);
		return testBooksList;
	}
}