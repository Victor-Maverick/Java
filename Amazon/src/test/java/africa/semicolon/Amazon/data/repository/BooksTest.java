package africa.semicolon.Amazon.data.repository;

import africa.semicolon.Amazon.data.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BooksTest {
    @Autowired
    private Books books;
    @BeforeEach
    public void setUp() {
        books.deleteAll();
    }

    @Test
    public void addBookTest(){
        Book book = new Book();
        books.save(book);
        assertEquals(1, books.count());
    }

}