package com.demo.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.demo.ds.Author;
import com.demo.ds.Books;
import com.demo.service.AuthorService;
import com.demo.service.BookService;

@Controller
public class BooksController {
	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/book")
	public String create(Model model) {
		model.addAttribute("books",new Books());
		model.addAttribute("authors",authorService.findAllAuthors());
		return "bookForm";
	}

	@PostMapping("/book/create")
	public String process(@Valid Books books, BindingResult result) {
		if(result.hasErrors()) {
			return "bookForm";
		}
		Author author = authorService.findAuthor(books.getAuthor().getId());
		books.setAuthor(author);
		bookService.save(books);
		return "redirect:/book/all";
	}
	
	@GetMapping("/book/all")
	public String showAllBooks(Model model) {
		model.addAttribute("books", bookService.findAll());
		return "books";
	}
	
	@GetMapping("/book/edit/{id}")
	public String updateForm(@PathVariable Integer id, Model model) {
		Books book = bookService.findBookById(id);
		model.addAttribute("book", book);
		return "updateBook";
	}
	@PostMapping("/book/update/{id}")
	public String updateProcess(@PathVariable Integer id,  Books book,BindingResult result, Model model) {
		if(result.hasErrors()) {
			book.setId(id);
			return "updateBook";
		}
		bookService.save(book);
		return "redirect:/book/all";
	}
	
	@GetMapping("/book/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		Books book = bookService.findBookById(id);
		bookService.delete(book);
		return "redirect:/book/all";
	}
}
