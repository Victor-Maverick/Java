package africa.semicolon.gistLover.data.repository;

import africa.semicolon.gistLover.data.model.Post;
import africa.semicolon.gistLover.dtos.CreatePostRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class PostRepositoryTest {
    @Autowired
    private PostRepository posts;

    @Test
    public void createPostTest(){
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("title");
        postRequest.setContent("content content");
        Post post = new Post();
        post.setTitle(post.getTitle());
        post.setContent(post.getContent());
        posts.save(post);
        assertNotNull(post.getId());
        assertEquals(1, posts.count());
    }

    @Test
    public void deleteByPostTest(){
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("title");
        postRequest.setContent("content content");
        Post post = new Post();
        post.setTitle(post.getTitle());
        post.setContent(post.getContent());
        posts.save(post);
        assertEquals(1, posts.count());
        posts.delete(post);
        assertEquals(0, posts.count());
    }

    @Test
    public void deleteByIdTest(){
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("title");
        postRequest.setContent("content content");
        Post post = new Post();
        post.setTitle(post.getTitle());
        post.setContent(post.getContent());
        posts.save(post);
        assertEquals(1, posts.count());
        posts.deleteById(post.getId());
        assertEquals(0, posts.count());
    }

}