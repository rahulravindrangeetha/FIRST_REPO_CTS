package com.booksandsubjectsmvchibernatedataboot;

import org.springframework.ui.ModelMap;

public interface BookService 
{
	public String addBook(Book book);
	
	public String deleteBook(long bookId,ModelMap map);
	
	public String searchBook(long bookId,ModelMap map);
}
