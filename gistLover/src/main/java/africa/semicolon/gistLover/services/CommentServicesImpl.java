package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.Comment;
import africa.semicolon.gistLover.data.repository.CommentRepository;
import africa.semicolon.gistLover.dtos.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServicesImpl implements CommentServices{
    @Autowired
    private CommentRepository commentRepository;
    public void createCommentWith(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setComment(commentRequest.getComment());
        commentRepository.save(comment);
    }
}
