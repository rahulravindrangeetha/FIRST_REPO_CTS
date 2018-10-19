package test;

import com.booksandsubjectsmvchibernatedataboot.Book;
import com.booksandsubjectsmvchibernatedataboot.BookDao;
import com.booksandsubjectsmvchibernatedataboot.BookDaoImpl;
import com.booksandsubjectsmvchibernatedataboot.BookRepo;
import com.booksandsubjectsmvchibernatedataboot.Subject;
import com.booksandsubjectsmvchibernatedataboot.SubjectDao;
import com.booksandsubjectsmvchibernatedataboot.SubjectDaoImpl;
import com.booksandsubjectsmvchibernatedataboot.SubjectRepo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;


public class DaoTest 
{
	@InjectMocks
	private BookDao bookDao = new BookDaoImpl();
	
	@InjectMocks
	private SubjectDao subjectDao = new SubjectDaoImpl();

	
	@Mock
	private BookRepo bookRepo;
	
	@Mock
	private SubjectRepo subjectRepo;
	
	
	@Before
	public void init()
	{
		initMocks(this);
	}
	
	@Test
	public void addBookTest()
	{
		Book book= new Book();
		book.setBookId(1);
		book.setPrice(13.12);
		book.setTitle("abc");
		book.setPublishDate(LocalDate.parse("11-11-2011", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		bookDao.addBook(book);
		verify(bookRepo).save(any(Book.class));
		
	}
	
	
	@Test
	public void searchBookTest()
	{
		Book book= new Book();
		book.setBookId(1);
		book.setPrice(13.12);
		book.setTitle("abc");
		book.setPublishDate(LocalDate.parse("11-11-2011", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		when(bookDao.searchBook(1)).thenReturn(book);
		Book searchedBoo=bookDao.searchBook(1);
		assertEquals(book,searchedBoo);
		verify(bookRepo).findOne(any(Long.class));
		
	}
	
	@Test
	public void deleteBookTest()
	{
		bookDao.deleteBook(1);
		verify(bookRepo).delete(any(Long.class));
		
	}
	
	@Test
	public void addSubjectTest()
	{
		Subject subject= new Subject();
		subject.setDurationInHours(111);
		subject.setSubjectId(1);
		subject.setSubTitle("abc");
		subjectDao.addSubject(subject);
		verify(subjectRepo).save(any(Subject.class));
		
	}
	
	
	@Test
	public void searchSubjectTest()
	{
		Subject subject= new Subject();
		subject.setDurationInHours(111);
		subject.setSubjectId(1);
		subject.setSubTitle("abc");
		when(subjectDao.searchSubject(1)).thenReturn(subject);
		Subject searchedSubject=subjectDao.searchSubject(1);
		assertEquals(subject,searchedSubject);
		verify(subjectRepo).findOne(any(Long.class));
		
	}
	
	@Test
	public void deleteSubjectTest()
	{
		subjectDao.deleteSubject(1);
		verify(subjectRepo).delete(any(Long.class));
		
	}
	
	
	

}
