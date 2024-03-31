package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.Post;
import africa.semicolon.gistLover.dtos.request.CreatePostRequest;
import africa.semicolon.gistLover.dtos.request.EditPostRequest;
import africa.semicolon.gistLover.dtos.request.ViewRequest;
import africa.semicolon.gistLover.dtos.response.CreatePostResponse;
import africa.semicolon.gistLover.dtos.response.ViewResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostServices {
    CreatePostResponse createPostWith(CreatePostRequest postRequest, String userName);
    void deletePost(String title);
    void editPost(String title, EditPostRequest editPostRequest);
    ViewResponse viewPost(ViewRequest ViewRequest viewRequest);
    List<Post> findAllPosts();

}
