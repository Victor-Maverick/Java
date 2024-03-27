package africa.semicolon.gistLover.data.repository;

import africa.semicolon.gistLover.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
