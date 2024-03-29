package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.dtos.request.CommentRequest;
import org.springframework.stereotype.Service;

@Service
public interface CommentServices {

    void createCommentWith(CommentRequest commentRequest);

}
