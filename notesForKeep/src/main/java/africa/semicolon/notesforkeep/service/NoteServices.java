package africa.semicolon.notesforkeep.service;

import africa.semicolon.notesforkeep.data.model.Note;
import africa.semicolon.notesforkeep.dtos.request.AddNoteRequest;
import africa.semicolon.notesforkeep.dtos.request.DeleteNoteRequest;
import africa.semicolon.notesforkeep.dtos.request.UpdateRequest;
import africa.semicolon.notesforkeep.dtos.responses.AddNoteResponse;
import africa.semicolon.notesforkeep.dtos.responses.UpdateResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteServices {

    AddNoteResponse addNote(AddNoteRequest addNoteRequest);
    UpdateResponse updateNote(UpdateRequest updateRequest);


    String deleteNote(DeleteNoteRequest deleteNoteRequest);

    List<Note> getNotesFor(String username);
}
