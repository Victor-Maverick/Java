package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.dtos.request.CreatePostRequest;
import africa.semicolon.gistLover.dtos.request.RegisterRequest;
import africa.semicolon.gistLover.dtos.response.RegisterUserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {

    RegisterUserResponse registerUserWith(RegisterRequest registerRequest);

    String deleteBy(String username);

    void createPostWith(CreatePostRequest postRequest, String userName);

    void viewPost(String title, String userName);
}
