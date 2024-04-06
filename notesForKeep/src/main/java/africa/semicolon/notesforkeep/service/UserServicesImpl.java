package africa.semicolon.notesforkeep.service;

import africa.semicolon.notesforkeep.data.model.User;
import africa.semicolon.notesforkeep.data.repository.Users;
import africa.semicolon.notesforkeep.dtos.request.AddNoteRequest;
import africa.semicolon.notesforkeep.dtos.request.LoginRequest;
import africa.semicolon.notesforkeep.dtos.request.RegisterRequest;
import africa.semicolon.notesforkeep.dtos.responses.AddNoteResponse;
import africa.semicolon.notesforkeep.dtos.responses.LoginResponse;
import africa.semicolon.notesforkeep.dtos.responses.RegisterResponse;
import africa.semicolon.notesforkeep.exceptions.IncorrectPasswordException;
import africa.semicolon.notesforkeep.exceptions.UserNotFoundException;
import africa.semicolon.notesforkeep.exceptions.UsernameExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static africa.semicolon.notesforkeep.utils.Mapper.map;
import static africa.semicolon.notesforkeep.utils.Mapper.mapLogin;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices{
    private final Users users;
    private final NoteServices noteServices;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        users.findAll().forEach(user -> {if(user.getUsername().equalsIgnoreCase(registerRequest.getUsername()))throw new UsernameExistsException("username exists");});
        User user = new User();
        map(user, registerRequest);
        users.save(user);
        return map(user);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = users.findByUsername(loginRequest.getUsername());
        if(user == null)throw new UserNotFoundException("no such user");
        if (!user.getPassword().equals(loginRequest.getPassword()))throw new IncorrectPasswordException("wrong password");
        user.setLoggedIn(true);
        users.save(user);
        return mapLogin(user);
    }

    @Override
    public AddNoteResponse addNote(AddNoteRequest addNoteRequest) {
        return noteServices.addNote(addNoteRequest);
    }

}
