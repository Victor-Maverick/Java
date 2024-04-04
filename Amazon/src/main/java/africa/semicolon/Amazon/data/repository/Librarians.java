package africa.semicolon.Amazon.data.repository;

import africa.semicolon.Amazon.data.model.Librarian;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Librarians extends MongoRepository<Librarian, String> {
    Librarian findByUsername(String username);
}
