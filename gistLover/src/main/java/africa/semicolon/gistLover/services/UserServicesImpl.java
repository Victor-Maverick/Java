package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.Post;
import africa.semicolon.gistLover.data.model.User;
import africa.semicolon.gistLover.data.model.View;
import africa.semicolon.gistLover.data.repository.PostRepository;
import africa.semicolon.gistLover.data.repository.UserRepository;
import africa.semicolon.gistLover.data.repository.ViewRepository;
import africa.semicolon.gistLover.dtos.request.CreatePostRequest;
import africa.semicolon.gistLover.dtos.request.RegisterRequest;
import africa.semicolon.gistLover.dtos.response.RegisterUserResponse;
import africa.semicolon.gistLover.exceptions.NonExistingUserException;
import africa.semicolon.gistLover.exceptions.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public void createPostWith(CreatePostRequest postRequest, String userName) {
        postServices.createPostWith(postRequest, userName);
    }

    public void viewPost(String title, String userName) {
        Post post = postRepository.findPostByTitle(title);
        View view = new View();
        view.setViewer(users.findUserByUserName(userName));
        List<View> viewList = new ArrayList<>();
        views.findAll().forEach(view1->{if(view1.getViewer().getUserName().equals(userName))viewList.add(view1);});
        post.setViews(viewList);


    }


    private void validateUsername(String userName) {
        boolean userExists = users.existsByUserName(userName);
        if (userExists) throw new UserExistsException("username already exists");
    }
}
