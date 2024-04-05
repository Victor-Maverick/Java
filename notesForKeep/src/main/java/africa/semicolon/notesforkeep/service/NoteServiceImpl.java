package africa.semicolon.notesforkeep.service;

import africa.semicolon.notesforkeep.data.model.Note;
import africa.semicolon.notesforkeep.data.model.User;
import africa.semicolon.notesforkeep.data.repository.Notes;
import africa.semicolon.notesforkeep.data.repository.Users;
import africa.semicolon.notesforkeep.dtos.request.AddNoteRequest;
import africa.semicolon.notesforkeep.dtos.request.UpdateRequest;
import africa.semicolon.notesforkeep.dtos.responses.AddNoteResponse;
import africa.semicolon.notesforkeep.dtos.responses.UpdateResponse;
import africa.semicolon.notesforkeep.exceptions.NoteNotFoundException;
import africa.semicolon.notesforkeep.exceptions.TitleExistsException;
import africa.semicolon.notesforkeep.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static africa.semicolon.notesforkeep.utils.Mapper.map;
import static africa.semicolon.notesforkeep.utils.Mapper.mapUpdate;

@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NoteServices {
    private final Notes notes;
    private final Users users;
    @Override
    public AddNoteResponse addNote(AddNoteRequest addNoteRequest) {
        notes.findAll().forEach(note -> {if (note.getHeader().equalsIgnoreCase(addNoteRequest.getHeader()))throw new TitleExistsException("title exists");});
        Note note = new Note();
        map(note, addNoteRequest);
        notes.save(note);
        User user = users.findByUsername(addNoteRequest.getAuthor());
        List<Note> userNotes = user.getNotes();
        userNotes.add(note);
        user.setNotes(userNotes);
        users.save(user);
        return map(note);
    }

    @Override
    public UpdateResponse updateNote(UpdateRequest updateRequest) {
        Note note = notes.findNoteBy(updateRequest.getTitle());
        if (note == null)throw new NoteNotFoundException("no note with that title does not exist");
        User user = users.findByUsername(updateRequest.getAuthor());
        if (user == null)throw new UserNotFoundException("note is not for author provided");
        note.setHeader(updateRequest.getTitle());
        note.setContent(updateRequest.getNewContent());
        note.setDateUpdated(LocalDateTime.now());
        notes.save(note);
        return mapUpdate(note);
    }
}
