package africa.semicolon.Amazon.data.repository;

import africa.semicolon.Amazon.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Books extends JpaRepository<Book, String> {

    boolean findByAuthor(String author);
    List<Book> findByTitleAndAuthor(String title, String author);
}
