package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.Post;
import africa.semicolon.gistLover.dtos.CreatePostRequest;
import africa.semicolon.gistLover.dtos.EditPostRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostServices {
    void createPostWith(CreatePostRequest postRequest);
    void deletePost(String title);
    void editPost(EditPostRequest editPostRequest);
    Post viewPost(String title);
    List<Post> findAllPosts();

}
