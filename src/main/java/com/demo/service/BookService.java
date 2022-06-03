package com.demo.service;

import java.util.List;

import com.demo.ds.Books;

public interface BookService {
	Books save(Books book);
	Books findBookById(int id);
	List<Books> findAll();
	List<Books> findBookByAuthorName(String name);
	void delete(Books book);
}
