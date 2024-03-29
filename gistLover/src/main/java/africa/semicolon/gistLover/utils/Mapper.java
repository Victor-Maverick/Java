package africa.semicolon.gistLover.utils;

import africa.semicolon.gistLover.data.model.Post;
import africa.semicolon.gistLover.data.model.User;
import africa.semicolon.gistLover.dtos.request.RegisterRequest;
import africa.semicolon.gistLover.dtos.response.CreatePostResponse;
import africa.semicolon.gistLover.dtos.response.RegisterUserResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {

    public static void map(RegisterRequest registerRequest, User user){
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setUserName(registerRequest.getUserName());
        user.setPassword(registerRequest.getPassword());
    }
    public static RegisterUserResponse map(User savedUser){
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setId(savedUser.getId());
        registerUserResponse.setUsername(savedUser.getUserName());
        registerUserResponse.setDateRegistered(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(savedUser.getDateCreated()));
        return registerUserResponse;
    }

    public static CreatePostResponse map(Post savedPost){
        CreatePostResponse postResponse = new CreatePostResponse();
        postResponse.setTitle(savedPost.getTitle());
        postResponse.setId(savedPost.getId());
        postResponse.setDateCreated(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(savedPost.getDateCreated()));
        return postResponse;
    }
}
