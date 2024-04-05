package africa.semicolon.notesforkeep.data.repository;

import africa.semicolon.notesforkeep.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Users extends MongoRepository<User, String> {

    User findByUsername(String username);
}
