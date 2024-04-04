package africa.semicolon.gistLover.data.repository;

import africa.semicolon.gistLover.data.model.Comment;
import africa.semicolon.gistLover.dtos.request.CommentRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

    @BeforeEach
    public void setup(){
        commentRepository.deleteAll();
    }
    @Test
    public void createCommentTest(){
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setComment("comment");
        Comment comment = new Comment();
        commentRequest.setComment(commentRequest.getComment());
        commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
    }

    @Test
    public void deleteByCommentTest(){
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setComment("comment");
        Comment comment = new Comment();
        commentRequest.setComment(commentRequest.getComment());
        commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
        commentRepository.delete(comment);
        assertEquals(0, commentRepository.count());
    }

    @Test
    public void deleteByIdTest(){
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setComment("comment");
        Comment comment = new Comment();
        commentRequest.setComment(commentRequest.getComment());
        commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
        commentRepository.deleteById(comment.getId());
        assertEquals(0, commentRepository.count());
    }

}