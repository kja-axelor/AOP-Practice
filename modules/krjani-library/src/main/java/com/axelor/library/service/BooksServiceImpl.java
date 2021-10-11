package com.axelor.library.service;

import com.axelor.library.db.Books;

public class BooksServiceImpl implements BooksService{

	@Override
	public void validateEmail(Books books) {
		System.err.println("Hello! inside BooksServiceImpl class");
	}
	
}
