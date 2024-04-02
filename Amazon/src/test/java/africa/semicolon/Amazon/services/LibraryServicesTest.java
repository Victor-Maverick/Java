package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Reader;
import africa.semicolon.Amazon.data.repository.Books;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
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

    @BeforeEach
    public void setup(){
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
    public void readerRequestBookTest(){
        CreateReaderRequest readerRequest = new CreateReaderRequest();

        Reader reader = new Reader();
    }

}