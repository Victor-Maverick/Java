package africa.semicolon.notesforkeep.utils;

import africa.semicolon.notesforkeep.data.model.Note;
import africa.semicolon.notesforkeep.data.model.User;
import africa.semicolon.notesforkeep.dtos.request.AddNoteRequest;
import africa.semicolon.notesforkeep.dtos.request.RegisterRequest;
import africa.semicolon.notesforkeep.dtos.request.UpdateRequest;
import africa.semicolon.notesforkeep.dtos.responses.AddNoteResponse;
import africa.semicolon.notesforkeep.dtos.responses.LoginResponse;
import africa.semicolon.notesforkeep.dtos.responses.RegisterResponse;
import africa.semicolon.notesforkeep.dtos.responses.UpdateResponse;

import java.time.LocalDateTime;

public class Mapper {
    public static AddNoteResponse map(Note note){
        AddNoteResponse noteResponse = new AddNoteResponse();
        noteResponse.setHeader(note.getHeader());
        noteResponse.setId(note.getId());
        noteResponse.setDateCreated(note.getDateCreated());
        return noteResponse;
    }

    public static void map(Note note, AddNoteRequest noteRequest){
        note.setHeader(noteRequest.getHeader());
        note.setContent(noteRequest.getContent());
        note.setDateCreated(LocalDateTime.now());
        note.setAuthor(noteRequest.getAuthor());
    }
    public static void map(User user, RegisterRequest request){
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
    }
    public static RegisterResponse map(User user){
        RegisterResponse response = new RegisterResponse();
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setDateRegistered(user.getDateCreated());
        return response;
    }

    public static UpdateResponse mapUpdate(Note note){
        UpdateResponse response = new UpdateResponse();
        response.setUpdatedTitle(note.getHeader());
        response.setUpdatedContent(note.getContent());
        response.setDateUpdated(note.getDateUpdated());
        return response;
    }

    public static LoginResponse mapLogin(User user){
        LoginResponse response = new LoginResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setLoggedIn(user.isLoggedIn());
        return response;
    }

    public static Note map(Note note, UpdateRequest updateRequest){
        Note updatedNote = new Note();
        updatedNote.setId(note.getId());
        updatedNote.setHeader(updateRequest.getNewTitle());
        updatedNote.setContent(updateRequest.getNewContent());
        updatedNote.setDateCreated(note.getDateCreated());
        updatedNote.setDateUpdated(LocalDateTime.now());
        updatedNote.setAuthor(note.getAuthor());
        return updatedNote;
    }
}
