package com.jurik99.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import com.jurik99.model.Book;
import com.jurik99.service.BookService;

@Controller
public class BookController {

	private BookService bookService = new BookService();

	// TODO : Marshalling and Unmarshalling need to be implemented cause for now we have no valid response
	@RequestMapping("/looseSearch")
	public @ResponseBody List<Book> performLooseSearch(@RequestParam("CHARS") final String chars) {
		return bookService.searchBooksByLooseMath(chars);
	}
}
