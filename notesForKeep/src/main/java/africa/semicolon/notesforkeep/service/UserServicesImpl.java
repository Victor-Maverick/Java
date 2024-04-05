package africa.semicolon.notesforkeep.service;

import africa.semicolon.notesforkeep.data.model.User;
import africa.semicolon.notesforkeep.data.repository.Users;
import africa.semicolon.notesforkeep.dtos.request.RegisterRequest;
import africa.semicolon.notesforkeep.dtos.responses.RegisterResponse;
import africa.semicolon.notesforkeep.exceptions.UsernameExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static africa.semicolon.notesforkeep.utils.Mapper.map;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices{
    private final Users users;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        users.findAll().forEach(user -> {if(user.getUsername().equalsIgnoreCase(registerRequest.getUsername()))throw new UsernameExistsException("username exists");});
        User user = new User();
        map(user, registerRequest);
        users.save(user);
        return map(user);
    }
}
