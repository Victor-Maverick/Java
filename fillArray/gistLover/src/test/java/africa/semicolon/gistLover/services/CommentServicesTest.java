package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.Comment;
import africa.semicolon.gistLover.data.repository.CommentRepository;
import africa.semicolon.gistLover.dtos.CommentRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServicesTest {
    @Autowired
    private CommentServices commentServices;
    @Autowired
    private CommentRepository repository;

    @Test
    public void createCommentTest(){
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setComment("new comment");
        Comment comment = new Comment();
        comment.setComment(commentRequest.getComment());
        commentServices.createCommentWith(commentRequest);
        assertEquals(1, repository.count());

    }

    @Test
    public void deleteCommentTest(){
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setComment("new comment");
        Comment comment = new Comment();
        comment.setComment(commentRequest.getComment());
        commentServices.createCommentWith(commentRequest);
        assertEquals(1, repository.count());

    }

}