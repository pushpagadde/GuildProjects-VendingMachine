/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.library.dao;

import com.sg.library.model.Author;
import com.sg.library.model.Publisher;
import com.sg.library.model.Book;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author PG
 */
public class LibraryDaoTest {
    
    public LibraryDao dao;        
    
    public LibraryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx
        = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("libraryDao", LibraryDao.class);

        // delete all books
        List<com.sg.library.model.Book> books = dao.getAllBooks();
        for (com.sg.library.model.Book currentBook : books) {
            dao.deleteBook(currentBook.getBookId());
        }
        //delete all authors
        List<Author> authors = dao.getAllAuthors();
        for (Author currentAuthor : authors) {
            dao.deleteAuthor(currentAuthor.getAuthorId());
        }
        // delete all publishers
        List<Publisher> publishers = dao.getAllPublishers();
        for (Publisher currentPublisher : publishers) {
            dao.deletePublisher(currentPublisher.getPublisherId());
        }
    }
    
    @After
    public void tearDown() {
        
    }

    
    @Test
    public void addGetPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Pub One");
        publisher.setStreet("123 Main Street");
        publisher.setCity("Publisher City");
        publisher.setState("OH");
        publisher.setZip("44123");
        publisher.setPhone("555-1212");

        dao.addPublisher(publisher);

        Publisher fromDao = dao.getPublisherById(publisher.getPublisherId());
        assertEquals(fromDao, publisher);
    }

    @Test
    public void deletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Pub One");
        publisher.setStreet("123 Main Street");
        publisher.setCity("Publisher City");
        publisher.setState("OH");
        publisher.setZip("44123");
        publisher.setPhone("555-1212");

        dao.addPublisher(publisher);

        Publisher fromDao = dao.getPublisherById(publisher.getPublisherId());
        assertEquals(fromDao, publisher);
        dao.deletePublisher(publisher.getPublisherId());
        assertNull(dao.getPublisherById(publisher.getPublisherId()));
    }

    @Test
    public void addGetAuthor() {
        Author author = new Author();
        author.setFirstName("Author");
        author.setLastName("Test");
        author.setStreet("49 Oak Street");
        author.setCity("Authortown");
        author.setState("OH");
        author.setZip("44398");
        author.setPhone("555-1234");

        dao.addAuthor(author);

        Author fromDao = dao.getAuthorById(author.getAuthorId());
        assertEquals(fromDao, author);
    }

    @Test
    public void deleteAuthor() {
        Author author = new Author();
        author.setFirstName("Author");
        author.setLastName("Test");
        author.setStreet("49 Oak Street");
        author.setCity("Authortown");
        author.setState("OH");
        author.setZip("44398");
        author.setPhone("555-1234");

        dao.addAuthor(author);

        Author fromDao = dao.getAuthorById(author.getAuthorId());
        assertEquals(fromDao, author);
        dao.deleteAuthor(author.getAuthorId());
        assertNull(dao.getAuthorById(author.getAuthorId()));
    }

    @Test
    public void addGetBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Pub One");
        publisher.setStreet("123 Main Street");
        publisher.setCity("Publisher City");
        publisher.setState("OH");
        publisher.setZip("44123");
        publisher.setPhone("555-1212");

        dao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("Author");
        author.setLastName("One");
        author.setStreet("45 Elm Street");
        author.setCity("Author City");
        author.setState("CA");
        author.setZip("90210");
        author.setPhone("555-1212");

        dao.addAuthor(author);

        Book b = new Book();
        b.setTitle("Great Book");
        b.setIsbn("12345");
        b.setPrice(new BigDecimal("12.95"));
        b.setPublishDate(LocalDate.parse("2010-01-01", 
                         DateTimeFormatter.ISO_DATE));
        b.setPublisher(publisher);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        b.setAuthors(authors);

        dao.addBook(b);

        Book fromDao = dao.getBookById(b.getBookId());

        assertEquals(fromDao, b);

    }

    @Test
    public void deleteBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Pub One");
        publisher.setStreet("123 Main Street");
        publisher.setCity("Publisher City");
        publisher.setState("OH");
        publisher.setZip("44123");
        publisher.setPhone("555-1212");

        dao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("Author");
        author.setLastName("One");
        author.setStreet("45 Elm Street");
        author.setCity("Author City");
        author.setState("CA");
        author.setZip("90210");
        author.setPhone("555-1212");

        dao.addAuthor(author);

        Book book = new Book();
        book.setTitle("Great Book");
        book.setIsbn("12345");
        book.setPrice(new BigDecimal("12.95"));
        book.setPublishDate(LocalDate.parse("2010-01-01", 
                            DateTimeFormatter.ISO_DATE));
        book.setPublisher(publisher);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        book.setAuthors(authors);

        dao.addBook(book);

        Book fromDao = dao.getBookById(book.getBookId());

        assertEquals(fromDao, book);
        dao.deleteBook(book.getBookId());
        assertNull(dao.getBookById(book.getBookId()));

    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
