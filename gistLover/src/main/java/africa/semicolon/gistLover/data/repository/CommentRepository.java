package africa.semicolon.gistLover.data.repository;

import africa.semicolon.gistLover.data.model.Comment;
import africa.semicolon.gistLover.data.model.Post;
import africa.semicolon.gistLover.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {

    Comment findByCommenter(User userByUserName);


}
