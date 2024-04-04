package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.Post;
import africa.semicolon.gistLover.dtos.request.*;
import africa.semicolon.gistLover.dtos.response.CommentResponse;
import africa.semicolon.gistLover.dtos.response.CreatePostResponse;
import africa.semicolon.gistLover.dtos.response.ViewResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostServices {
    CreatePostResponse createPostWith(CreatePostRequest postRequest);
    void deletePost(DeletePostRequest deletePostRequest);
    void editPost(String title, EditPostRequest editPostRequest);
    ViewResponse viewPost(ViewRequest ViewRequest);
    List<Post> findAllPosts();

    CommentResponse commentWith(CommentRequest commentRequest);

    void deleteComment(DeleteCommentRequest deleteCommentRequest);
}
