package com.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.dao.BooksRepository;
import com.demo.ds.Books;
import com.demo.service.BookService;
@Service
public class BookServiceImpl implements BookService{
	
	private final BooksRepository booksRepository;
	
	public BookServiceImpl(BooksRepository booksRepository) {
		super();
		this.booksRepository = booksRepository;
	}
	
	

	@Override
	public Books save(Books book) {
		return booksRepository.save(book);
	}

	@Override
	public Books findBookById(int id) {
			return booksRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("INVALID BOOK ID" + id));
	}

	@Override
	public List<Books> findAll() {
		return booksRepository.findAll();
	}

	@Override
	public List<Books> findBookByAuthorName(String name) {
		return booksRepository.findBooksByAuthorName(name);
	}

	@Override
	public void delete(Books book) {
		booksRepository.delete(book);
	}



	

}
