package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.Comment;
import africa.semicolon.gistLover.data.repository.CommentRepository;
import africa.semicolon.gistLover.dtos.request.CommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServicesImpl implements CommentServices{

    private final CommentRepository commentRepository;
    public void createCommentWith(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setComment(commentRequest.getComment());
        commentRepository.save(comment);
    }
}
