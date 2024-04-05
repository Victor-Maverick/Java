package africa.semicolon.notesforkeep.service;

import africa.semicolon.notesforkeep.dtos.request.AddNoteRequest;
import africa.semicolon.notesforkeep.dtos.request.UpdateRequest;
import africa.semicolon.notesforkeep.dtos.responses.AddNoteResponse;
import africa.semicolon.notesforkeep.dtos.responses.UpdateResponse;
import org.springframework.stereotype.Service;

@Service
public interface NoteServices {

    AddNoteResponse addNote(AddNoteRequest addNoteRequest);
    UpdateResponse updateNote(UpdateRequest updateRequest);
}
