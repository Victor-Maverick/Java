package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.repository.PostRepository;
import africa.semicolon.gistLover.dtos.request.CreatePostRequest;
import africa.semicolon.gistLover.dtos.request.EditPostRequest;
import africa.semicolon.gistLover.exceptions.GistLoverAppException;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostServicesTest {
    @Autowired
    private PostServices postServices;
    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    public void collapseAll(){
        postRepository.deleteAll();
    }

    @Test
    public void createPostWith() {
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("title");
        postRequest.setContent("content content");
        postServices.createPostWith(postRequest);
        assertThat(postRepository.count(), Matchers.is(equalTo(1L)));

    }

    @Test
    public void deletePost() {
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("title");
        postRequest.setContent("content content");
        postServices.createPostWith(postRequest);
        assertThat(postRepository.count(), Matchers.is(equalTo(1L)));
        postServices.deletePost("title");
        assertThat(postRepository.count(), Matchers.is(equalTo(0L)));
    }

    @Test
    public void deleteNonExistingPost() {
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("title");
        postRequest.setContent("content content");
        postServices.createPostWith(postRequest);
        assertThat(postRepository.count(), Matchers.is(equalTo(1L)));
        postServices.deletePost("title");
        assertThat(postRepository.count(), Matchers.is(equalTo(0L)));
        try{
            postServices.deletePost("title");
        }
        catch (GistLoverAppException e){
            assertEquals(e.getMessage(), "nonexistent post");
        }
    }

    @Test
    public void editPost() {
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("title");
        postRequest.setContent("content content");
        var savedPost = postServices.createPostWith(postRequest);
        assertThat(postRepository.count(), Matchers.is(equalTo(1L)));
        EditPostRequest editPostRequest = new EditPostRequest();
        editPostRequest.setTitle("new title");
        editPostRequest.setContent("new content");
        postServices.editPost("title", editPostRequest);
        System.out.println(savedPost.getTitle());
        assertEquals("new title", postRepository.findPostByTitle("new title").getTitle());
    }

    @Test
    public void editNonExistingPost() {
        assertThat(postRepository.count(), Matchers.is(equalTo(0L)));
        EditPostRequest editPostRequest = new EditPostRequest();
        editPostRequest.setTitle("new title");
        editPostRequest.setContent("new content");
        try {
            postServices.editPost("title", editPostRequest);
        }
        catch (GistLoverAppException e){
            assertEquals(e.getMessage(), "nonexistent post");
        }

    }
    @Test
    public void viewPost() {
    }

    @Test
    public void findAllPosts() {
    }
}