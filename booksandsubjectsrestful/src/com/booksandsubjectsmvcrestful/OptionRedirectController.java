package com.booksandsubjectsmvcrestful;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Controller
@RequestMapping("/books")
@CrossOrigin
public class OptionRedirectController 
{
	
	@RequestMapping(method=RequestMethod.GET,headers="Accept=application/json")
	@ResponseBody
	public ResponseEntity getAllBooks() 
	{
		System.out.println("hereeeeeeeeeeeeee");
		Session sessionOne = HibernateConnector.getSessionFactory().openSession();
        sessionOne.beginTransaction();
        List<Book> book=sessionOne.createQuery("from Book").list();
        System.out.println("book from db->"+book);
        sessionOne.getTransaction().commit();
        List<BookRest> booksRest= getBookRest(book);
        System.out.println("booksRest->"+booksRest);
        
		return new ResponseEntity(booksRest,HttpStatus.OK)	;		

	}

	@RequestMapping(value="/{bookId}",method=RequestMethod.GET,headers="Accept=application/json")
	@ResponseBody
	public ResponseEntity getBook(@PathVariable("bookId") long bookId) throws BookNotFoundException 
	{
		Session sessionOne = HibernateConnector.getSessionFactory().openSession();
        sessionOne.beginTransaction();
        Book book=(Book)sessionOne.get(Book.class, bookId);
        sessionOne.getTransaction().commit();
        System.out.println("book from db->"+book);
        if(book==null)
        	throw new BookNotFoundException();
        BookRest bookRest = bookConverter(book);
       
        System.out.println("booksRest->"+bookRest);
        return new ResponseEntity(bookRest,HttpStatus.OK)	;
     }
	
	@RequestMapping(value="/{bookId}",method=RequestMethod.DELETE,headers="Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	public void deleteBook(@PathVariable("bookId")long bookId) throws BookNotFoundException
	{
		Session sessionOne = HibernateConnector.getSessionFactory().openSession();
        sessionOne.beginTransaction();
        Book book=(Book)sessionOne.get(Book.class, bookId);
        System.out.println("book from db->"+book);
        if(book!=null)
        {
        	Subject subject=book.getSubject();
        	if(subject!=null)
        	{
        		subject.getReference().remove(book);
            	sessionOne.update(subject);
        	}
        	else
        	{
        		sessionOne.delete(book);
        	}

        }
        else
        {
        	sessionOne.getTransaction().commit();
        	throw new BookNotFoundException();
        }
        sessionOne.getTransaction().commit();
	}
		
	@RequestMapping(value="/{bookId}",method=RequestMethod.PUT,headers="Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	public void updateBook(@PathVariable("bookId")long bookId,@RequestBody BookRest updatedBook) throws BookNotFoundException
	{
		Session sessionOne = HibernateConnector.getSessionFactory().openSession();
        sessionOne.beginTransaction();
        Book book=(Book)sessionOne.get(Book.class, bookId);
        System.out.println("book from db->"+book);
        if(book!=null)
        {
        	book=updateBookDB(book,updatedBook);
           sessionOne.update(book);
        }
        else
        {
        	sessionOne.getTransaction().commit();
        	throw new BookNotFoundException();
        }
        sessionOne.getTransaction().commit();
	}
	
	@RequestMapping(method=RequestMethod.POST,consumes="application/json",headers="Accept=application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createBook(@RequestBody BookRest newBook) throws SomeIssueException
	{
		try
		{
		Session sessionOne = HibernateConnector.getSessionFactory().openSession();
        sessionOne.beginTransaction();
        Book book= new Book();
        convertToDbBook(newBook,book);
        sessionOne.save(book);
        sessionOne.getTransaction().commit();
		}
		catch(Exception e)
		{
			throw new SomeIssueException();
		}
	}

	private void convertToDbBook(BookRest bookRest, Book book) 
	{
		book.setPrice(bookRest.getPrice());
		book.setPublishDate(bookRest.getPublishDate());
		book.setTitle(bookRest.getTitle());
		book.setVolume(bookRest.getVolume());
		book.setBookId(bookRest.getBookId());
		
	}

	private Book updateBookDB(Book book,BookRest updatedBook) 
	{
		book.setPrice(updatedBook.getPrice());
		book.setPublishDate(updatedBook.getPublishDate());
		book.setTitle(updatedBook.getTitle());
		book.setVolume(updatedBook.getVolume());
		return book;
		
	}
	
	private List<BookRest> getBookRest(List<Book> books) 
	{
		List<BookRest> bookRest= new ArrayList<BookRest>();
		for(Book book : books)
		{
			BookRest bookrest= bookConverter(book);
			bookRest.add(bookrest);
		}
		// TODO Auto-generated method stub
		return bookRest;
	}

	private BookRest bookConverter(Book book) 
	{
		System.out.println("book in converter"+book);
		BookRest bookRest = new BookRest();
		bookRest.setPrice(book.getPrice());
		bookRest.setPublishDate(book.getPublishDate());
		bookRest.setTitle(book.getTitle());
		bookRest.setVolume(book.getVolume());
		bookRest.setBookId(book.getBookId());
		System.out.println("Book rest in converter"+bookRest);
		return bookRest;
		
	}
	

	


}
