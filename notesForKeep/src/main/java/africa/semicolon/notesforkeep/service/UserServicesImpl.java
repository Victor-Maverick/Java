package africa.semicolon.notesforkeep.service;

import africa.semicolon.notesforkeep.data.model.Note;
import africa.semicolon.notesforkeep.data.model.User;
import africa.semicolon.notesforkeep.data.repository.Users;
import africa.semicolon.notesforkeep.dtos.request.*;
import africa.semicolon.notesforkeep.dtos.responses.AddNoteResponse;
import africa.semicolon.notesforkeep.dtos.responses.LoginResponse;
import africa.semicolon.notesforkeep.dtos.responses.RegisterResponse;
import africa.semicolon.notesforkeep.dtos.responses.UpdateResponse;
import africa.semicolon.notesforkeep.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

import static africa.semicolon.notesforkeep.utils.Mapper.map;
import static africa.semicolon.notesforkeep.utils.Mapper.mapLogin;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices{
    private final Users users;
    private final NoteServices noteServices;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        validateRegistration(registerRequest);
        users.findAll().forEach(user -> {if(user.getUsername().equalsIgnoreCase(registerRequest.getUsername()))throw new UsernameExistsException("username exists");});
        User user = new User();
        map(user, registerRequest);
        users.save(user);
        return map(user);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = users.findByUsername(loginRequest.getUsername());
        validateUser(user);
        validateLoginPassword(loginRequest, user);
        user.setLoggedIn(true);
        users.save(user);
        return mapLogin(user);
    }

    private static void validateRegistration(RegisterRequest registerRequest) {
        if (!registerRequest.getUsername().matches("[a-zA-Z]+")) throw new InputMisMatchException("Invalid Input for username");
        if (registerRequest.getUsername().isEmpty())throw new InputMisMatchException("Invalid Input for username");
        if (registerRequest.getPassword().isEmpty())
            throw new InputMisMatchException("Invalid Password, provide a Password");
    }
    private static void validateLoginPassword(LoginRequest loginRequest, User user) {
        if (!user.getPassword().equals(loginRequest.getPassword()))throw new IncorrectPasswordException("wrong password");
    }

    private static void validateUser(User user) {
        if(user == null)throw new UserNotFoundException("no such user");
    }

    @Override
    public AddNoteResponse addNote(AddNoteRequest addNoteRequest) {
        return noteServices.addNote(addNoteRequest);
    }

    @Override
    public UpdateResponse updateNote(UpdateRequest updateRequest) {
        return noteServices.updateNote(updateRequest);
    }

    @Override
    public String logout(LogoutRequest logoutRequest) {
        User user = users.findByUsername(logoutRequest.getUsername());
        validateUser(user);
        user.setLoggedIn(false);
        users.save(user);
        return "Logout success";
    }

    @Override
    public String deleteUser(DeleteUserRequest deleteUserRequest) {
        User user = users.findByUsername(deleteUserRequest.getUsername());
        validateUser(user);
        if (!user.isLoggedIn())throw new LoginException("log in first");
        users.deleteById(user.getId());
        return "delete success";
    }

    @Override
    public String deleteNote(DeleteNoteRequest deleteNoteRequest) {
        return noteServices.deleteNote(deleteNoteRequest);
    }

    @Override
    public List<Note> getNotesFor(String username) {
        return noteServices.getNotesFor(username);
    }


}
