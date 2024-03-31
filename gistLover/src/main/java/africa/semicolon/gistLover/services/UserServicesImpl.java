package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.User;
import africa.semicolon.gistLover.data.repository.PostRepository;
import africa.semicolon.gistLover.data.repository.UserRepository;
import africa.semicolon.gistLover.data.repository.ViewRepository;
import africa.semicolon.gistLover.dtos.request.CommentRequest;
import africa.semicolon.gistLover.dtos.request.CreatePostRequest;
import africa.semicolon.gistLover.dtos.request.RegisterRequest;
import africa.semicolon.gistLover.dtos.request.ViewRequest;
import africa.semicolon.gistLover.dtos.response.RegisterUserResponse;
import africa.semicolon.gistLover.exceptions.NonExistingUserException;
import africa.semicolon.gistLover.exceptions.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static africa.semicolon.gistLover.utils.Mapper.map;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserRepository users;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    PostServices postServices;
    @Autowired
    ViewRepository views;

    public RegisterUserResponse registerUserWith(RegisterRequest registerRequest) {
        registerRequest.setUserName(registerRequest.getUserName().toLowerCase());
        validateUsername(registerRequest.getUserName());
        User user = new User();
        map(registerRequest, user);
        User savedUser  = users.save(user);
        return map(savedUser);

    }


    public String deleteBy(String username) {
        Optional<User> user = users.findByUserName(username);
        if (user.isPresent()) users.deleteUserByUserName(username);
        else throw new NonExistingUserException("non existing user");
        return "delete success";
    }

    public void createPostWith(CreatePostRequest postRequest) {
        postServices.createPostWith(postRequest);
    }

    public void viewPost(ViewRequest viewRequest) {
        postServices.viewPost(viewRequest);

    }

    public void commentWith(CommentRequest commentRequest) {
        postServices.commentWith(commentRequest);
    }


    private void validateUsername(String userName) {
        boolean userExists = users.existsByUserName(userName);
        if (userExists) throw new UserExistsException("username already exists");
    }
}
