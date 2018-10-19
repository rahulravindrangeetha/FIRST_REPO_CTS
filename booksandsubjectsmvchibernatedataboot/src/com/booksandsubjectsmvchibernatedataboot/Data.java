package com.booksandsubjectsmvchibernatedataboot;
import java.util.List;

public class Data 
{
	private List<Book> books;
	private List<Subject> subjects;
	public List<Book> getBooks() 
	{
		return books;
	}
	public void setBooks(List<Book> books)
	{
		this.books = books;
	}
	public List<Subject> getSubjects() 
	{
		return subjects;
	}
	public void setSubjects(List<Subject> subjects)
	{
		this.subjects = subjects;
	}

}
