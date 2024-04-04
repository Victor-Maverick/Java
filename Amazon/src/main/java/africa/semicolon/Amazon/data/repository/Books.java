package africa.semicolon.Amazon.data.repository;

import africa.semicolon.Amazon.data.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Books extends MongoRepository<Book, String> {
    Book findBookByTitle(String title);


}
