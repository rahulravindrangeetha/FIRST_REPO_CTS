package com.booksandsubjectsmvchibernatedataboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao 
{
	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private SubjectRepo subjectRepo;

	@Override
	public void addBook(Book book) 
	{
		bookRepo.save(book);

	}

	@Override
	public Book searchBook(long bookId) 
	{
		Book book=bookRepo.findOne(bookId);
		return book;
	}

	@Override
	public void deleteBook(long bookId) 
	{
		bookRepo.delete(bookId);

	}

}
