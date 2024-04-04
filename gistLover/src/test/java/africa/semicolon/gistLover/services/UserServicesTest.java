package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.User;
import africa.semicolon.gistLover.data.repository.CommentRepository;
import africa.semicolon.gistLover.data.repository.PostRepository;
import africa.semicolon.gistLover.data.repository.UserRepository;
import africa.semicolon.gistLover.dtos.request.*;
import africa.semicolon.gistLover.exceptions.GistLoverAppException;
import africa.semicolon.gistLover.exceptions.NonExistingPostException;
import africa.semicolon.gistLover.exceptions.NonExistingUserException;
import africa.semicolon.gistLover.exceptions.UserExistsException;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServicesTest {

    @Autowired
    private UserServices userServices;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository posts;
    @Autowired
    private CommentRepository comments;

    @BeforeEach
    public void setup(){
        posts.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void createUserTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userServices.registerUserWith(registerRequest);
        assertEquals(1, userRepository.count());
    }

    @Test
    public void createNonUniqueUser_throwsExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userServices.registerUserWith(registerRequest);
        try{
            userServices.registerUserWith(registerRequest);
        }
        catch (UserExistsException e){
            assertEquals(e.getMessage(), "username already exists");
        }
        assertEquals(1, userRepository.count());
    }

    @Test
    public void deleteUserTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userServices.registerUserWith(registerRequest);
        userServices.deleteBy("username");
        assertEquals(0, userRepository.count());
    }

    @Test
    public void deleteNonExistingUser_throwsExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userServices.registerUserWith(registerRequest);
        try {
            userServices.deleteBy("wrong username");
        }
        catch (NonExistingUserException e){
            assertEquals(e.getMessage(), "non existing user");
        }
        assertEquals(1, userRepository.count());
    }

    @Test
    public void viewPostTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userServices.registerUserWith(registerRequest);
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("title");
        postRequest.setContent("content content");
        postRequest.setUsername(registerRequest.getUserName());
        userServices.createPostWith(postRequest);
        assertEquals(1, posts.count());
        ViewRequest viewRequest = new ViewRequest();
        viewRequest.setUsername("username");
        viewRequest.setTitle("title");
        userServices.viewPost(viewRequest);
        assertEquals(1, posts.findPostByTitle("title").getViews().size());
        }

    @Test
    public void viewPostWithNonExistingTitle_throwsExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userServices.registerUserWith(registerRequest);
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("title");
        postRequest.setContent("content content");
        postRequest.setUsername(registerRequest.getUserName());
        userServices.createPostWith(postRequest);
        assertEquals(1, posts.count());
        ViewRequest viewRequest = new ViewRequest();
        viewRequest.setUsername("username");
        viewRequest.setTitle("wrong title");
        try {
            userServices.viewPost(viewRequest);
        }
        catch (NonExistingPostException e){
            assertEquals(e.getMessage(), "nonexistent post");
        }
        assertEquals(0, posts.findPostByTitle("title").getViews().size());
        }

    @Test
    public void testUserComment(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userServices.registerUserWith(registerRequest);
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("title");
        postRequest.setContent("content content");
        postRequest.setUsername(registerRequest.getUserName());
        userServices.createPostWith(postRequest);
        assertEquals(1, posts.count());
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setTitle("title");
        commentRequest.setCommenterName("username");
        commentRequest.setComment("my Comment");
        userServices.commentWith(commentRequest);
        assertEquals(1, posts.findPostByTitle("title").getComments().size());
    }

    @Test
    public void NonExistentUserCommentTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userServices.registerUserWith(registerRequest);
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("title");
        postRequest.setContent("content content");
        postRequest.setUsername(registerRequest.getUserName());
        userServices.createPostWith(postRequest);
        assertEquals(1, posts.count());
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setTitle("title");
        commentRequest.setCommenterName("wrong username");
        commentRequest.setComment("my Comment");
        try {
            userServices.commentWith(commentRequest);
        }
        catch (GistLoverAppException e){
            assertEquals(e.getMessage(), "register first");
        }
        assertEquals(0, posts.findPostByTitle("title").getComments().size());
    }

    @Test
    public void deletePost() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userServices.registerUserWith(registerRequest);
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("title");
        postRequest.setContent("content content");
        postRequest.setUsername(registerRequest.getUserName());
        userServices.createPostWith(postRequest);
        assertThat(posts.count(), Matchers.is(equalTo(1L)));
        DeletePostRequest deleteRequest = new DeletePostRequest();
        deleteRequest.setUsername("username");
        deleteRequest.setPassword("password");
        deleteRequest.setTitle("title");
        userServices.deletePost(deleteRequest);
        assertThat(posts.count(), Matchers.is(equalTo(0L)));
    }

    @Test
    public void deleteCommentTest() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userServices.registerUserWith(registerRequest);
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("title");
        postRequest.setContent("content content");
        postRequest.setUsername(registerRequest.getUserName());
        userServices.createPostWith(postRequest);
        assertEquals(1, posts.count());
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setTitle("title");
        commentRequest.setCommenterName("username");
        commentRequest.setComment("my Comment");
        userServices.commentWith(commentRequest);
        assertEquals(1, posts.findPostByTitle("title").getComments().size());
        DeleteCommentRequest deleteCommentRequest = new DeleteCommentRequest();
        deleteCommentRequest.setTitle("title");
        deleteCommentRequest.setUserName("username");
        deleteCommentRequest.setComment("my Comment");
        System.out.println(posts.findPostByTitle("title").getComments());
        userServices.deleteComment(deleteCommentRequest);
        assertEquals(0, comments.count());
        System.out.println(posts.findPostByTitle("title").getComments());
        assertEquals(0, posts.findPostByTitle("title").getComments().size());
    }
}