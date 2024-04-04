package africa.semicolon.Amazon.controllers;

import africa.semicolon.Amazon.data.repository.Books;
import africa.semicolon.Amazon.data.repository.Librarians;
import africa.semicolon.Amazon.data.repository.Readers;
import africa.semicolon.Amazon.dtos.requests.*;
import africa.semicolon.Amazon.exceptions.AmazonAppException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LibraryControllerTest {
    @Autowired
    private LibraryController libraryController;
    @Autowired
    private Librarians librarians;
    @Autowired
    private Books books;
    @Autowired
    private Readers readers;


    @BeforeEach
    public void collapseAll(){
        librarians.deleteAll();
        readers.deleteAll();
    }
    @Test
    public void addLibrarianTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryController.registerLibrarian(readerRequest);
        assertEquals(1, librarians.count());
    }

    @Test
    public void addNonUniqueUsernamesTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryController.registerLibrarian(readerRequest);
        assertEquals(1, librarians.count());
        RegisterRequest readerRequest2 = new RegisterRequest();
        readerRequest2.setUsername("username");
        readerRequest2.setPassword("password");
        readerRequest2.setAddress("semicolon Sabo");
        readerRequest2.setPhoneNumber("08148624877");
        try {
            libraryController.registerLibrarian(readerRequest2);
        }
        catch (AmazonAppException e){
            assertEquals(e.getMessage(), "username exists");
        }
        assertEquals(1, librarians.count());

    }

    @Test
    public void librarianLoginTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryController.registerLibrarian(readerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        libraryController.signLibrarianIn(loginRequest);
        assertTrue(librarians.findByUsername("username").isLoggedIn());
    }

    @Test
    public void librarianWrongPasswordLoginAttemptTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryController.registerLibrarian(readerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("wrong password");
        try {
            libraryController.signLibrarianIn(loginRequest);
        }
        catch(AmazonAppException e){
            assertEquals(e.getMessage(), "wrong password");
        }
        assertFalse(librarians.findByUsername("username").isLoggedIn());
    }

    @Test
    public void librarianLogoutTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryController.registerLibrarian(readerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        libraryController.signLibrarianIn(loginRequest);
        assertTrue(librarians.findByUsername("username").isLoggedIn());
        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setUsername("username");
        libraryController.signLibrarianOut(logoutRequest);
        assertFalse(librarians.findByUsername("username").isLoggedIn());
    }

    @Test
    public void addBookTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("my book");
        addBookRequest.setAuthor("victor");
        addBookRequest.setIsbn(231);
        libraryController.addBook(addBookRequest);
        assertEquals(1, books.count());
    }

    @Test
    public void addTwoBooksWithSameIsbnTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("my book");
        addBookRequest.setAuthor("victor");
        addBookRequest.setIsbn(231);
        libraryController.addBook(addBookRequest);
        assertEquals(1, books.count());
        AddBookRequest addBookRequest2 = new AddBookRequest();
        addBookRequest2.setBookTitle("my book");
        addBookRequest2.setAuthor("victor");
        addBookRequest2.setIsbn(231);
        try {
            libraryController.addBook(addBookRequest2);
        }
        catch (AmazonAppException e){
            assertEquals(e.getMessage(), "book exists with that isb number");
        }
        assertEquals(1, books.count());
    }

    @Test
    public void registerReaderTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryController.registerReader(readerRequest);
        assertEquals(1, readers.count());
    }

    @Test
    public void registerNonUniqueUsersTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryController.registerReader(readerRequest);
        assertEquals(1, readers.count());
        RegisterRequest readerRequest2 = new RegisterRequest();
        readerRequest2.setUsername("username");
        readerRequest2.setPassword("password");
        readerRequest2.setAddress("semicolon Sabo");
        readerRequest2.setPhoneNumber("08148624877");
        try {
            libraryController.registerReader(readerRequest2);
        }
        catch (AmazonAppException e){
            assertEquals(e.getMessage(), "user exists with that username");
        }
        assertEquals(1, readers.count());
    }

    @Test
    public void readerLoginTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryController.registerReader(readerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        libraryController.logReaderIn(loginRequest);
        assertTrue(readers.findByUsername("username").isLoggedIn());
    }

    @Test
    public void wrongPasswordLoginAttemptTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryController.registerReader(readerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("wrong password");
        try {
            libraryController.logReaderIn(loginRequest);
        }
        catch (AmazonAppException e){
            assertEquals(e.getMessage(), "wrong password");
        }
        assertFalse(readers.findByUsername("username").isLoggedIn());
    }

    @Test
    public void requestExistingBookTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryController.registerReader(readerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        libraryController.logReaderIn(loginRequest);
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("my book");
        addBookRequest.setAuthor("victor");
        addBookRequest.setIsbn(231);
        assertEquals("my book", addBookRequest.getBookTitle());
        libraryController.addBook(addBookRequest);
        BorrowRequest borrowRequest = new BorrowRequest();
        borrowRequest.setTitle("my book");
        borrowRequest.setAuthor("victor");
        borrowRequest.setUsername("username");
        libraryController.borrowBook(borrowRequest);
        assertTrue(books.findBookByTitle("my book").isReserved());
    }

}