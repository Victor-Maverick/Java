package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.dtos.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {

    void registerUserWith(RegisterRequest registerRequest);

}
