package africa.semicolon.notesforkeep.service;

import africa.semicolon.notesforkeep.data.model.Note;
import africa.semicolon.notesforkeep.data.model.User;
import africa.semicolon.notesforkeep.data.repository.Notes;
import africa.semicolon.notesforkeep.data.repository.Users;
import africa.semicolon.notesforkeep.dtos.request.AddNoteRequest;
import africa.semicolon.notesforkeep.dtos.request.DeleteNoteRequest;
import africa.semicolon.notesforkeep.dtos.request.UpdateRequest;
import africa.semicolon.notesforkeep.dtos.responses.AddNoteResponse;
import africa.semicolon.notesforkeep.dtos.responses.UpdateResponse;
import africa.semicolon.notesforkeep.exceptions.LoginException;
import africa.semicolon.notesforkeep.exceptions.NoteNotFoundException;
import africa.semicolon.notesforkeep.exceptions.TitleExistsException;
import africa.semicolon.notesforkeep.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        User user = users.findByUsername(addNoteRequest.getAuthor());
        validateUser(user);
        validateUserLogin(user);
        notes.save(note);
        users.save(user);
        return map(note);
    }

    private static void validateUserLogin(User user) {
        if(!user.isLoggedIn())throw new LoginException("log in first");
    }

    @Override
    public UpdateResponse updateNote(UpdateRequest updateRequest) {
        Note note = notes.findNoteBy(updateRequest.getTitle());
        User user = users.findByUsername(updateRequest.getAuthor());
        validate(note, user);
        if(!user.isLoggedIn())throw new LoginException("log in first");
        Note updatedNote = map(note, updateRequest);
        notes.delete(note);
        notes.save(updatedNote);
        return mapUpdate(updatedNote);
    }

    private static void validateUser(User user) {
        if (user == null)throw new UserNotFoundException("note is not for author provided");
    }

    private static void validateNote(Note note) {
        if (note == null)throw new NoteNotFoundException("no note with that title does not exist");
    }

    @Override
    public String deleteNote(DeleteNoteRequest deleteNoteRequest) {
        Note note = notes.findNoteBy(deleteNoteRequest.getNoteTitle());
        User user = users.findByUsername(deleteNoteRequest.getAuthor());
        validate(note, user);
        validateUserLogin(user);
        List<Note>userNotes = user.getNotes();
        notes.delete(note);
        userNotes.remove(note);
        user.setNotes(userNotes);
        users.save(user);
        return "delete success";
    }

    @Override
    public List<Note> getNotesFor(String username) {
        User user = users.findByUsername(username);
        List<Note> userNotes = user.getNotes();
        notes.findAll().forEach(note -> {if(note.getAuthor().equalsIgnoreCase(username))userNotes.add(note);});
        return userNotes;
    }

    private static void validate(Note note, User user) {
        validateNote(note);
        validateUser(user);
    }
}
