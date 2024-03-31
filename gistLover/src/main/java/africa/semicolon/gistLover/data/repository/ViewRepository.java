package africa.semicolon.gistLover.data.repository;

import africa.semicolon.gistLover.data.model.User;
import africa.semicolon.gistLover.data.model.View;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewRepository extends MongoRepository<View, String> {
    View findByViewer(User userByUserName);
}
