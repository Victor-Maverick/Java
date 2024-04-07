package africa.semicolon.notesforkeep.controllers;

import africa.semicolon.notesforkeep.dtos.request.*;
import africa.semicolon.notesforkeep.dtos.responses.*;
import africa.semicolon.notesforkeep.exceptions.NoteManagerException;
import africa.semicolon.notesforkeep.service.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserServices userServices;

    @DeleteMapping("/delete-note")
    public ResponseEntity<?> deleteNote(DeleteNoteRequest deleteNoteRequest){
        try{
            String response = userServices.deleteNote(deleteNoteRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }
        catch (NoteManagerException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/sign-off")
    public ResponseEntity<?> deleteUser(DeleteUserRequest deleteRequest){
        try{
            String response = userServices.deleteUser(deleteRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }
        catch (NoteManagerException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/update-note")
    public ResponseEntity<?> updateNote(UpdateRequest updateRequest){
        try{
            UpdateResponse response = userServices.updateNote(updateRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }
        catch (NoteManagerException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/add-note")
    public ResponseEntity<?> addNote(AddNoteRequest noteRequest){
        try{
            AddNoteResponse response = userServices.addNote(noteRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }
        catch (NoteManagerException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(LogoutRequest logoutRequest){
        try{
            String response = userServices.logout(logoutRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }
        catch (NoteManagerException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(LoginRequest loginRequest){
        try{
            LoginResponse response = userServices.login(loginRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }
        catch (NoteManagerException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(RegisterRequest registerRequest){
        try{
            RegisterResponse response = userServices.register(registerRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }
        catch (NoteManagerException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

}
