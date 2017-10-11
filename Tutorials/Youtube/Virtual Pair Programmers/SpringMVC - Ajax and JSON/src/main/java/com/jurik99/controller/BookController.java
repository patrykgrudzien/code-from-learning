package com.jurik99.controller;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import com.jurik99.model.Book;
import com.jurik99.service.BookService;

@Controller
@Api(value = "bookSearcher", description = "Book Controller responsible for AJAX searching")
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(final BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/performLooseSearch", method = RequestMethod.GET)
	public @ResponseBody List<Book> performLooseSearch(@RequestParam("CHARS") final String chars) {
		return bookService.searchBooksByLooseMath(chars);
	}
}
