package africa.semicolon.notesforkeep.service;

import africa.semicolon.notesforkeep.data.repository.Notes;
import africa.semicolon.notesforkeep.data.repository.Users;
import africa.semicolon.notesforkeep.dtos.request.AddNoteRequest;
import africa.semicolon.notesforkeep.dtos.request.LoginRequest;
import africa.semicolon.notesforkeep.dtos.request.RegisterRequest;
import africa.semicolon.notesforkeep.exceptions.NoteManagerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServicesTest{
    @Autowired
    UserServices userServices;
    @Autowired
    Users users;
    @Autowired
    Notes notes;

    @BeforeEach
    public void collapseAll(){
        notes.deleteAll();
        users.deleteAll();
    }
    @Test
    public void addUserTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("0902234532");
        userServices.register(registerRequest);
        assertNotNull(users.findByUsername("username").getId());
        assertEquals(1, users.count());
    }

    @Test
    public void addTwoUsersWithSameUsernameTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("0902234532");
        userServices.register(registerRequest);
        assertNotNull(users.findByUsername("username").getId());
        assertEquals(1, users.count());
        RegisterRequest registerRequest2 = new RegisterRequest();
        registerRequest2.setUsername("username");
        registerRequest2.setPassword("password");
        registerRequest2.setEmail("vic@gmail.com");
        registerRequest2.setPhoneNumber("0902234532");
        try {
            userServices.register(registerRequest2);
        }
        catch (NoteManagerException e){
            assertEquals(e.getMessage(), "username exists");
        }
        assertEquals(1, users.count());
    }

    @Test
    public void userLoginTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("0902234532");
        userServices.register(registerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        userServices.login(loginRequest);
        assertTrue(users.findByUsername("username").isLoggedIn());
    }
    @Test
    public void loginWrongUsernameTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("0902234532");
        userServices.register(registerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("wrong username");
        loginRequest.setPassword("password");
        try {
            userServices.login(loginRequest);
        }
        catch (NoteManagerException e){
            assertEquals(e.getMessage(), "no such user");
        }
        assertFalse(users.findByUsername("username").isLoggedIn());
    }

    @Test
    public void wrongPasswordLoginAttempt(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("0902234532");
        userServices.register(registerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("wrong password");
        try {
            userServices.login(loginRequest);
        }
        catch (NoteManagerException e){
            assertEquals(e.getMessage(), "wrong password");
        }
        assertFalse(users.findByUsername("username").isLoggedIn());
    }

    @Test
    public void addNoteWhileLoggedInTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("0902234532");
        userServices.register(registerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        userServices.login(loginRequest);
        AddNoteRequest addNoteRequest = new AddNoteRequest();
        addNoteRequest.setHeader("first note");
        addNoteRequest.setContent("note content");
        addNoteRequest.setAuthor("username");
        userServices.addNote(addNoteRequest);
        assertEquals(1, notes.count());
    }

    @Test
    public void addNoteWhileLoggedOutAttemptTest(){
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
        try {
            userServices.addNote(addNoteRequest);
        }
        catch (NoteManagerException e){
            assertEquals(e.getMessage(), "log in first");
        }
        assertEquals(0, notes.count());
    }

    @Test
    public void updateNoteTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("0902234532");
        userServices.register(registerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        userServices.login(loginRequest);
        AddNoteRequest addNoteRequest = new AddNoteRequest();
        addNoteRequest.setHeader("first note");
        addNoteRequest.setContent("note content");
        addNoteRequest.setAuthor("username");
        userServices.addNote(addNoteRequest);

    }


}