package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.Post;
import africa.semicolon.gistLover.data.repository.PostRepository;
import africa.semicolon.gistLover.dtos.CreatePostRequest;
import africa.semicolon.gistLover.dtos.EditPostRequest;
import africa.semicolon.gistLover.dtos.NonExistingPostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServicesImpl implements PostServices{
    @Autowired
    private PostRepository postRepository;
    public void createPostWith(CreatePostRequest postRequest) {
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        postRepository.save(post);

    }

    public void deletePost(String title) {
        Optional<Post> post = postRepository.findByTitle(title);
        if (post.isPresent())postRepository.deletePostByTitle(title);
        else throw new NonExistingPostException("nonexistent post");

    }

    public void editPost(EditPostRequest editPostRequest) {

    }

    public Post viewPost(String title) {
        return null;
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
}
