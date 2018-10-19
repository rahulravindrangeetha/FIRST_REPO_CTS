package com.booksandsubjectsmvchibernatedataboot;

public interface BookDao 
{
	public void addBook(Book book);
	
	public Book searchBook(long bookId);
	
	public void deleteBook(long bookId);
	

}
