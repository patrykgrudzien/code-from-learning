package com.jurik99.service;

import java.util.List;

import com.jurik99.model.Book;

public interface BookService {

	List<Book> searchBooksByLooseMath(String chars);
}
