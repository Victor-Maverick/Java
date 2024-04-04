package africa.semicolon.Amazon.data.repository;

import africa.semicolon.Amazon.data.model.Reader;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Readers extends MongoRepository<Reader, String> {
    Reader findByUsername(String username);
}
