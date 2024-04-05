package africa.semicolon.notesforkeep.utils;

import africa.semicolon.notesforkeep.data.model.Note;
import africa.semicolon.notesforkeep.data.model.User;
import africa.semicolon.notesforkeep.dtos.request.AddNoteRequest;
import africa.semicolon.notesforkeep.dtos.request.RegisterRequest;
import africa.semicolon.notesforkeep.dtos.responses.AddNoteResponse;
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
        note.setContent(noteRequest.getHeader());
        note.setHeader(noteRequest.getHeader());
        note.setDateCreated(LocalDateTime.now());
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

}
