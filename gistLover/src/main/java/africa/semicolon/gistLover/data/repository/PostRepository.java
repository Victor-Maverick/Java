package africa.semicolon.gistLover.data.repository;

import africa.semicolon.gistLover.data.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    Optional<Post> findByTitle(String title);

    void deletePostByTitle(String title);
}
