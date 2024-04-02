package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.repository.Books;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
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

    @Test
    public void addBookTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("my book");
        addBookRequest.setAuthor("victor");
        addBookRequest.setIsbn("231");
        libraryServices.addBookWith(addBookRequest);
        assertEquals(1, books.count());
    }

    @Test
    public void addBooksOfSameAuthorTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBookTitle("my book");
        addBookRequest.setAuthor("victor");
        addBookRequest.setIsbn("231");
        libraryServices.addBookWith(addBookRequest);
    }

}