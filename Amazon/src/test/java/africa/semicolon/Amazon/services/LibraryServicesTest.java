package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Reader;
import africa.semicolon.Amazon.data.repository.Books;
import africa.semicolon.Amazon.data.repository.Readers;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.requests.BorrowRequest;
import africa.semicolon.Amazon.dtos.requests.CreateReaderRequest;
import africa.semicolon.Amazon.dtos.requests.IssueRequest;
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

    @BeforeEach
    public void setup(){
        readers.deleteAll();
        books.deleteAll();
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
        CreateReaderRequest readerRequest = new CreateReaderRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryServices.registerReaderWith(readerRequest);
        assertEquals(1, readers.count());

    }

    @Test
    public void registerTwoSameReadersTest(){
        CreateReaderRequest readerRequest = new CreateReaderRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryServices.registerReaderWith(readerRequest);
        assertEquals(1, readers.count());
        CreateReaderRequest readerRequest2 = new CreateReaderRequest();
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
    public void bookRequestTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("my book");
        addBookRequest.setAuthor("victor");
        addBookRequest.setIsbn(231);
        assertEquals("my book", addBookRequest.getBookTitle());
        libraryServices.addBookWith(addBookRequest);
        BorrowRequest borrowRequest = new BorrowRequest();
        borrowRequest.setTitle("my book");
        libraryServices.requestForBookWith(borrowRequest);
        assertTrue(books.findBookByTitle("my book").isReserved());
    }

    @Test
    public void bookNonExistingTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("my book");
        addBookRequest.setAuthor("victor");
        addBookRequest.setIsbn(231);
        libraryServices.addBookWith(addBookRequest);
        BorrowRequest borrowRequest = new BorrowRequest();
        borrowRequest.setTitle("book");
        try {
            libraryServices.requestForBookWith(borrowRequest);
        }
        catch (AmazonAppException e){
            assertEquals(e.getMessage(), "no book with that title");
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
        issueRequest.setAuthor("victor");
        libraryServices.issueBook(issueRequest);
    }


}