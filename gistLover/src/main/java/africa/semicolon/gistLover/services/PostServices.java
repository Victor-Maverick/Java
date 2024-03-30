package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.Post;
import africa.semicolon.gistLover.dtos.request.CreatePostRequest;
import africa.semicolon.gistLover.dtos.request.EditPostRequest;
import africa.semicolon.gistLover.dtos.response.CreatePostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostServices {
    CreatePostResponse createPostWith(CreatePostRequest postRequest, String userName);
    void deletePost(String title);
    void editPost(String title, EditPostRequest editPostRequest);
    Post viewPost(String title, String username);
    List<Post> findAllPosts();

}
