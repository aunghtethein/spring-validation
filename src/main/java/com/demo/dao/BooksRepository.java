package com.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.ds.Books;
@Repository
public interface BooksRepository extends JpaRepository<Books, Integer>{

	@Query("select b from Books b where b.author.name=:name")
	List<Books> findBooksByAuthorName(@Param("name") String name);
}
