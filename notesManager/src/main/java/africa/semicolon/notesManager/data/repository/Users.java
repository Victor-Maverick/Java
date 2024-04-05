package africa.semicolon.notesManager.data.repository;

import africa.semicolon.notesManager.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users extends MongoRepository<User, String> {

}
