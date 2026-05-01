package com.dao;

import java.util.List;

import com.model.Book;

public interface BookDao {

	int addBook(Book book);

	int updateBook(Book book);

	int deleteBookById(int id);

	Book findBookById(int id);

	List<Book> findAllBooks();

}
