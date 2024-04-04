package africa.semicolon.Amazon.controllers;

import africa.semicolon.Amazon.data.repository.Books;
import africa.semicolon.Amazon.data.repository.Librarians;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.requests.LoginRequest;
import africa.semicolon.Amazon.dtos.requests.LogoutRequest;
import africa.semicolon.Amazon.dtos.requests.RegisterRequest;
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


    @BeforeEach
    public void collapseAll(){
        librarians.deleteAll();
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
}