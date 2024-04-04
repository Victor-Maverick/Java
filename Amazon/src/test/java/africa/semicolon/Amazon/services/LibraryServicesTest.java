package africa.semicolon.Amazon.services;
import africa.semicolon.Amazon.data.model.Reader;
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
public class LibraryServicesTest {
    @Autowired
    LibraryServices libraryServices;
    @Autowired
    private Books books;
    @Autowired
    private Readers readers;
    @Autowired
    private Librarians librarians;

    @BeforeEach
    public void setup(){
        readers.deleteAll();
        books.deleteAll();
        librarians.deleteAll();
    }

    @Test
    public void registerLibrarianTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryServices.registerLibrarianWith(readerRequest);
        assertEquals(1, librarians.count());
    }

    @Test
    public void LibrarianLoginTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryServices.registerLibrarianWith(readerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        libraryServices.librarianLogin(loginRequest);
        assertTrue(librarians.findByUsername("username").isLoggedIn());
    }

    @Test
    public void WrongUsernameLoginTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryServices.registerLibrarianWith(readerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("wrong username");
        loginRequest.setPassword("wrong password");
        try {
            libraryServices.librarianLogin(loginRequest);
        }
        catch (AmazonAppException e){
            assertEquals(e.getMessage(), "no such staff");
        }

    }

    @Test
    public void librarianWrongPasswordLoginTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryServices.registerLibrarianWith(readerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("wrong password");
        try {
            libraryServices.librarianLogin(loginRequest);
        }
        catch (AmazonAppException e){
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
        libraryServices.registerLibrarianWith(readerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        libraryServices.librarianLogin(loginRequest);
        assertTrue(librarians.findByUsername("username").isLoggedIn());
        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setUsername("username");
        libraryServices.librarianLogout(logoutRequest);
        assertFalse(librarians.findByUsername("username").isLoggedIn());
    }

    @Test
    public void addBookTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("my book");
        addBookRequest.setAuthor("victor");
        addBookRequest.setIsbn(231);
        libraryServices.addBookWith(addBookRequest);
        assertEquals(1, books.count());
    }

    @Test
    public void addBooksOfSameIsbnTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("my book");
        addBookRequest.setAuthor("victor");
        addBookRequest.setIsbn(231);
        libraryServices.addBookWith(addBookRequest);
        AddBookRequest addBookRequest2 = new AddBookRequest();
        addBookRequest2.setBookTitle("my book");
        addBookRequest2.setAuthor("victor");
        addBookRequest2.setIsbn(231);
        try {
            libraryServices.addBookWith(addBookRequest2);
        }
        catch(AmazonAppException e){
            assertEquals(e.getMessage(), "book exists");
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
        libraryServices.registerReaderWith(readerRequest);
        assertEquals(1, readers.count());

    }

    @Test
    public void registerTwoSameReadersTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryServices.registerReaderWith(readerRequest);
        assertEquals(1, readers.count());
        RegisterRequest readerRequest2 = new RegisterRequest();
        readerRequest2.setUsername("username");
        readerRequest2.setPassword("password");
        readerRequest2.setAddress("semicolon Sabo");
        readerRequest2.setPhoneNumber("08148624877");
        try {
            libraryServices.registerReaderWith(readerRequest2);
        }
        catch (AmazonAppException e){
            assertEquals(e.getMessage(), "Reader exists with that username");
        }
        assertEquals(1, readers.count());
    }

    @Test
    public void requestBookTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("my book");
        addBookRequest.setAuthor("victor");
        addBookRequest.setIsbn(231);
        assertEquals("my book", addBookRequest.getBookTitle());
        libraryServices.addBookWith(addBookRequest);
        BorrowRequest borrowRequest = new BorrowRequest();
        borrowRequest.setTitle("my book");
        borrowRequest.setAuthor("victor");
        libraryServices.requestForBookWith(borrowRequest);
        assertTrue(books.findBookByTitle("my book").isReserved());
    }

    @Test
    public void requestNonExistingBookTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("my book");
        addBookRequest.setAuthor("victor");
        addBookRequest.setIsbn(231);
        libraryServices.addBookWith(addBookRequest);
        BorrowRequest borrowRequest = new BorrowRequest();
        borrowRequest.setTitle("book");
        borrowRequest.setAuthor("victor");
        try {
            libraryServices.requestForBookWith(borrowRequest);
        }
        catch (AmazonAppException e){
            assertEquals(e.getMessage(), "no book with that title");
        }
    }


    @Test
    public void requestExistingBookWithWrongAuthorTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("my book");
        addBookRequest.setAuthor("victor");
        addBookRequest.setIsbn(231);
        libraryServices.addBookWith(addBookRequest);
        BorrowRequest borrowRequest = new BorrowRequest();
        borrowRequest.setTitle("my book");
        borrowRequest.setAuthor("wrong author");
        try {
            libraryServices.requestForBookWith(borrowRequest);
        }
        catch (AmazonAppException e){
            assertEquals(e.getMessage(), "no such author for that book");
        }
    }

    @Test
    public void returnBookTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("my book");
        addBookRequest.setAuthor("victor");
        addBookRequest.setIsbn(231);
        assertEquals("my book", addBookRequest.getBookTitle());
        libraryServices.addBookWith(addBookRequest);
        Reader reader = new Reader();
        reader.setUsername("username");
        reader.setPassword("password");
        reader.setAddress("semicolon");
        BorrowRequest borrowRequest = new BorrowRequest();
        borrowRequest.setTitle("my book");
        borrowRequest.setUsername(reader.getUsername());
        borrowRequest.setAuthor("victor");
        libraryServices.requestForBookWith(borrowRequest);
        assertTrue(books.findBookByTitle("my book").isReserved());
        IssueRequest issueRequest = new IssueRequest();
        issueRequest.setUsername(reader.getUsername());
        issueRequest.setTitle("my book");
        issueRequest.setAuthor("victor");
        libraryServices.issueBook(issueRequest);
        assertFalse(books.findBookByTitle("my book").isReserved());
    }

    @Test
    public void returnWrongBook_throwsExceptionTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("my book");
        addBookRequest.setAuthor("victor");
        addBookRequest.setIsbn(231);
        assertEquals("my book", addBookRequest.getBookTitle());
        libraryServices.addBookWith(addBookRequest);
        Reader reader = new Reader();
        reader.setUsername("username");
        reader.setPassword("password");
        reader.setAddress("semicolon");
        BorrowRequest borrowRequest = new BorrowRequest();
        borrowRequest.setTitle("my book");
        borrowRequest.setUsername(reader.getUsername());
        borrowRequest.setAuthor("victor");
        libraryServices.requestForBookWith(borrowRequest);
        assertTrue(books.findBookByTitle("my book").isReserved());
        IssueRequest issueRequest = new IssueRequest();
        issueRequest.setUsername(reader.getUsername());
        issueRequest.setTitle("book");
        issueRequest.setAuthor("victor");
        try {
            libraryServices.issueBook(issueRequest);
        }
        catch(AmazonAppException e){
            assertEquals(e.getMessage(), "no such book");
        }
        assertTrue(books.findBookByTitle("my book").isReserved());
    }

    @Test
    public void returnBookWithWrongAuthorTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("my book");
        addBookRequest.setAuthor("victor");
        addBookRequest.setIsbn(231);
        assertEquals("my book", addBookRequest.getBookTitle());
        libraryServices.addBookWith(addBookRequest);
        Reader reader = new Reader();
        reader.setUsername("username");
        reader.setPassword("password");
        reader.setAddress("semicolon");
        BorrowRequest borrowRequest = new BorrowRequest();
        borrowRequest.setTitle("my book");
        borrowRequest.setUsername(reader.getUsername());
        borrowRequest.setAuthor("victor");
        libraryServices.requestForBookWith(borrowRequest);
        assertTrue(books.findBookByTitle("my book").isReserved());
        IssueRequest issueRequest = new IssueRequest();
        issueRequest.setUsername(reader.getUsername());
        issueRequest.setTitle("my book");
        issueRequest.setAuthor("wrong username");
        try {
            libraryServices.issueBook(issueRequest);
        }
        catch(AmazonAppException e){
            assertEquals(e.getMessage(), "wrong author");
        }
        assertTrue(books.findBookByTitle("my book").isReserved());
    }

    @Test
    public void readerLoginTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryServices.registerReaderWith(readerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        libraryServices.logReaderIn(loginRequest);
        assertTrue(readers.findByUsername("username").isLoggedIn());
    }

    @Test
    public void WrongPasswordAttemptLoginTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username1");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryServices.registerReaderWith(readerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username1");
        loginRequest.setPassword("wrong password");
        try {
            libraryServices.logReaderIn(loginRequest);
        }
        catch (AmazonAppException e){
            assertEquals(e.getMessage(), "wrong password");
        }
        assertFalse(readers.findByUsername("username1").isLoggedIn());
    }

    @Test
    public void WrongUsernameAttemptLoginTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username1");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryServices.registerReaderWith(readerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("wrong username");
        loginRequest.setPassword("password");
        try {
            libraryServices.logReaderIn(loginRequest);
        }
        catch (AmazonAppException e){
            assertEquals(e.getMessage(), "user does not exist with that username");
        }
        assertFalse(readers.findByUsername("username1").isLoggedIn());
    }

    @Test
    public void readerLogoutTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryServices.registerReaderWith(readerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        libraryServices.logReaderIn(loginRequest);
        assertTrue(readers.findByUsername("username").isLoggedIn());
        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setUsername("username");
        libraryServices.readerLogout(logoutRequest);
    }

    @Test
    public void wrongUsernameLogoutAttemptTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryServices.registerReaderWith(readerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        libraryServices.logReaderIn(loginRequest);
        assertTrue(readers.findByUsername("username").isLoggedIn());
        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setUsername("wrong username");
        try {
            libraryServices.readerLogout(logoutRequest);
        }
        catch(AmazonAppException e){
            assertEquals(e.getMessage(), "user does not exist with that username");
        }
    }

}
