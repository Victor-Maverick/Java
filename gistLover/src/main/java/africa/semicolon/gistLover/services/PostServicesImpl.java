package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.Post;
import africa.semicolon.gistLover.data.model.View;
import africa.semicolon.gistLover.data.repository.PostRepository;
import africa.semicolon.gistLover.data.repository.UserRepository;
import africa.semicolon.gistLover.dtos.request.CreatePostRequest;
import africa.semicolon.gistLover.dtos.request.EditPostRequest;
import africa.semicolon.gistLover.dtos.response.CreatePostResponse;
import africa.semicolon.gistLover.exceptions.NonExistingPostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static africa.semicolon.gistLover.utils.Mapper.map;

@Service
public class PostServicesImpl implements PostServices{
    @Autowired
    private PostRepository postRepository;
    @Autowired
    UserRepository users;
    public CreatePostResponse createPostWith(CreatePostRequest postRequest) {
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        var newPost = postRepository.save(post);
        return map(newPost);
    }

    public void deletePost(String title) {
        Optional<Post> post = postRepository.findByTitle(title);
        if (post.isPresent())postRepository.deletePostByTitle(title);
        else throw new NonExistingPostException("nonexistent post");

    }

    public void editPost(String title, EditPostRequest editPostRequest) {
        Post post = postRepository.findPostByTitle(title);
        if(post == null)throw new NonExistingPostException("nonexistent post");
        post.setTitle(editPostRequest.getTitle());
        post.setContent(editPostRequest.getContent());
        postRepository.save(post);
    }

    public Post viewPost(String title, String username) {
        Post post = postRepository.findPostByTitle(title);
        if(post == null)throw new NonExistingPostException("nonexistent post");
        View view = new View();
        return post;
    }


    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public void addView(Post post, View view) {
        List<View> views = post.getViews();
        views.add(view);
    }
}
