package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.User;
import africa.semicolon.gistLover.data.repository.UserRepository;
import africa.semicolon.gistLover.dtos.RegisterRequest;
import africa.semicolon.gistLover.dtos.RegisterUserResponse;
import africa.semicolon.gistLover.exceptions.UserExistsException;
import africa.semicolon.gistLover.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserRepository users;

    public RegisterUserResponse registerUserWith(RegisterRequest registerRequest) {
        registerRequest.setUserName(registerRequest.getUserName().toLowerCase());
        validateUsername(registerRequest.getUserName());
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setUserName(registerRequest.getUserName());
        user.setPassword(registerRequest.getPassword());
        User savedUser  = users.save(user);

        return Mapper.map(savedUser);


    }

    private void validateUsername(String userName) {
        boolean userExists = users.existsByUserName(userName);
        if (userExists) throw new UserExistsException("username already exists");
    }
}
