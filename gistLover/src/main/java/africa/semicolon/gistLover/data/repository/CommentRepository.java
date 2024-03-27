package africa.semicolon.gistLover.data.repository;

import africa.semicolon.gistLover.data.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
