package com.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.dao.AuthorRepository;
import com.demo.ds.Author;
import com.demo.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	private final AuthorRepository authorRepo;
	
	public AuthorServiceImpl(AuthorRepository authorRepo) {
		super();
		this.authorRepo = authorRepo;
	}
	

	@Override
	public Author save(Author author) {
	
		return authorRepo.save(author);
	}

	@Override
	public Author findAuthor(int id) {
	
		return authorRepo.findById(id).orElse(null);
	}

	@Override
	public List<Author> findAllAuthors() {
	
		return authorRepo.findAll();
	}
	
	

}
