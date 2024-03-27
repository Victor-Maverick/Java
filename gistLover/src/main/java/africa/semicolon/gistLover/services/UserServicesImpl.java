package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.User;
import africa.semicolon.gistLover.data.repository.UserRepository;
import africa.semicolon.gistLover.dtos.RegisterRequest;
import africa.semicolon.gistLover.dtos.RegisterUserResponse;
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

    public RegisterUserResponse registerUserWith(RegisterRequest registerRequest) {
        registerRequest.setUserName(registerRequest.getUserName().toLowerCase());
        validateUsername(registerRequest.getUserName());
        User user = new User();
        map(registerRequest, user);
        User savedUser  = users.save(user);
        return map(savedUser);

    }

    public void deleteBy(String username) {
        Optional<User> user = users.findByUserName(username);
        if(user.isEmpty())throw new NonExistingUserException("non existing user");
        users.deleteById(user.get().getId());
    }


    private void validateUsername(String userName) {
        boolean userExists = users.existsByUserName(userName);
        if (userExists) throw new UserExistsException("username already exists");
    }
}
