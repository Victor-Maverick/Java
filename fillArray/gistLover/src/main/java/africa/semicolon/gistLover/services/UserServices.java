package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.dtos.RegisterRequest;
import africa.semicolon.gistLover.dtos.RegisterUserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {

    RegisterUserResponse registerUserWith(RegisterRequest registerRequest);

    void deleteBy(String username);
}
