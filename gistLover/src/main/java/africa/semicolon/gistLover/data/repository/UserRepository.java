package africa.semicolon.gistLover.data.repository;

import africa.semicolon.gistLover.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByUserName(String userName);

    void deleteUserByUserName(String username);

    Optional<User> findByUserName(String username);

    User findUserByUserName(String username);
}
