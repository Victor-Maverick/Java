package africa.semicolon.notesforkeep.service;

import africa.semicolon.notesforkeep.dtos.request.*;
import africa.semicolon.notesforkeep.dtos.responses.AddNoteResponse;
import africa.semicolon.notesforkeep.dtos.responses.LoginResponse;
import africa.semicolon.notesforkeep.dtos.responses.RegisterResponse;
import africa.semicolon.notesforkeep.dtos.responses.UpdateResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {

    RegisterResponse register(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest loginRequest);

    AddNoteResponse addNote(AddNoteRequest addNoteRequest);

    UpdateResponse updateNote(UpdateRequest updateRequest);

    String logout(LogoutRequest logoutRequest);

    String deleteUser(DeleteUserRequest deleteUserRequest);
    String deleteNote(DeleteNoteRequest deleteNoteRequest);

    List<Note> getNotesFor(String username);
}
