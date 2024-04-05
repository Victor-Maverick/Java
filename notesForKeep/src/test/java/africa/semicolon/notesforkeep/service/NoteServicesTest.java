package africa.semicolon.notesforkeep.service;

import africa.semicolon.notesforkeep.data.repository.Notes;
import africa.semicolon.notesforkeep.data.repository.Users;
import africa.semicolon.notesforkeep.dtos.request.AddNoteRequest;
import africa.semicolon.notesforkeep.dtos.request.RegisterRequest;
import africa.semicolon.notesforkeep.dtos.request.UpdateRequest;
import africa.semicolon.notesforkeep.exceptions.NoteManagerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class NoteServicesTest {
    @Autowired
    NoteServiceImpl services;
    @Autowired
    Notes notes;
    @Autowired
    UserServices userServices;
    @Autowired
    Users users;

    @BeforeEach
    public void collapseAll() {
        users.deleteAll();
        notes.deleteAll();
    }

    @Test
    public void addNoteTest(){
        AddNoteRequest addNoteRequest = new AddNoteRequest();
        services.addNote(addNoteRequest);
        assertEquals(1, notes.count());
    }

    @Test
    public void addNonUniqueNoteTest(){
        AddNoteRequest addNoteRequest = new AddNoteRequest();
        addNoteRequest.setHeader("first note");
        addNoteRequest.setContent("note content");
        services.addNote(addNoteRequest);
        assertEquals(1, notes.count());
        AddNoteRequest addNoteRequest2 = new AddNoteRequest();
        addNoteRequest2.setHeader("first note");
        addNoteRequest2.setContent("note content");
        try {
            services.addNote(addNoteRequest2);
        }
        catch (NoteManagerException e){
            assertEquals(e.getMessage(), "title exists");
        }
        assertEquals(1, notes.count());

    }

    @Test
    public void updateNoteTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("0902234532");
        userServices.register(registerRequest);
        AddNoteRequest addNoteRequest = new AddNoteRequest();
        addNoteRequest.setHeader("first note");
        addNoteRequest.setContent("note content");
        addNoteRequest.setAuthor("username");
        services.addNote(addNoteRequest);
        assertEquals(1, notes.count());
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.setTitle("first note");
        updateRequest.setNewTitle("new note");
        updateRequest.setAuthor("username");
        services.updateNote(updateRequest);
        assertNotNull(notes.findNoteBy("new note").getId());
        assertEquals(1, notes.count());
    }

    @Test
    public void updateNonExistingNoteTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("0902234532");
        userServices.register(registerRequest);
        AddNoteRequest addNoteRequest = new AddNoteRequest();
        addNoteRequest.setHeader("first note");
        addNoteRequest.setContent("note content");
        addNoteRequest.setAuthor("username");
        services.addNote(addNoteRequest);
        assertEquals(1, notes.count());
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.setTitle("wrong note");
        updateRequest.setNewTitle("new note");
        updateRequest.setAuthor("username");
        try {
            services.updateNote(updateRequest);
        }
        catch (NoteManagerException e){
            assertEquals(e.getMessage(), "no note with that title does not exist");
        }
    }

    @Test
    public void updateWithWrongAuthorTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("0902234532");
        userServices.register(registerRequest);
        AddNoteRequest addNoteRequest = new AddNoteRequest();
        addNoteRequest.setHeader("first note");
        addNoteRequest.setContent("note content");
        addNoteRequest.setAuthor("username");
        services.addNote(addNoteRequest);
        assertEquals(1, notes.count());
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.setTitle("first note");
        updateRequest.setNewTitle("new note");
        updateRequest.setAuthor("wrong username");
        try {
            services.updateNote(updateRequest);
        }
        catch (NoteManagerException e){
            assertEquals(e.getMessage(), "note is not for author provided");
        }
    }

}