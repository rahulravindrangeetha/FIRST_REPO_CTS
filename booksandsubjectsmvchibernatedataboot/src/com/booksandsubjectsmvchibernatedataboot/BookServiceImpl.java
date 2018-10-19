package com.booksandsubjectsmvchibernatedataboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class BookServiceImpl implements BookService 
{
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private SubjectDao subjectDao;

	@Override
	public String addBook(Book book) 
	{
		bookDao.addBook(book);
		return "bookSuccess";
	}

	@Override
	public String deleteBook(long bookId, ModelMap map) 
	{
		// TODO Auto-generated method stub
        Book book=bookDao.searchBook(bookId);
        if(book!=null)
        {
        	Subject subject=book.getSubject();
        	if(subject == null)
        	{
        		bookDao.deleteBook(bookId);
        	}
        	else
        	{
                subject.getReference().remove(book);
                
                subjectDao.addSubject(subject);
        	}

        	map.addAttribute("deleteStatus",'y');
        }
        else
        {
        	map.addAttribute("deleteStatus",'n');
        }
		return "deleteBookInfo";
	}

	@Override
	public String searchBook(long bookId, ModelMap map) 
	{
		Book book = bookDao.searchBook(bookId);
		System.out.println("book->"+book);
		map.addAttribute("book",book);
		return "bookInfo";
	}

}
