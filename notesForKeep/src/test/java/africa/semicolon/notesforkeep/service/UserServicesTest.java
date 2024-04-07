package africa.semicolon.notesforkeep.service;

import africa.semicolon.notesforkeep.data.repository.Notes;
import africa.semicolon.notesforkeep.data.repository.Users;
import africa.semicolon.notesforkeep.dtos.request.*;
import africa.semicolon.notesforkeep.exceptions.NoteManagerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.InputMismatchException;

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
    public void setup(){
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
    public void addUserWithEmptyUsernameTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("#@username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("0902234532");
        try {
            userServices.register(registerRequest);
        }catch (NoteManagerException e){
            assertEquals(e.getMessage(), "Invalid Input for username");
        }
        assertEquals(0, users.count());
    }

    @Test
    public void addUserWithInvalidUsernameTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("#@username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("0902234532");
        try {
            userServices.register(registerRequest);
        }catch (NoteManagerException e){
            assertEquals(e.getMessage(), "Invalid Input for username");
        }
        assertEquals(0, users.count());
    }
    @Test
    public void addUserWithEmptyPasswordTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("0902234532");
        try {
            userServices.register(registerRequest);
        }catch (NoteManagerException e){
            assertEquals(e.getMessage(), "Invalid Password, provide a Password");
        }
        assertEquals(0, users.count());
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
    public void deleteUserWhenLoggedInTest(){
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
        assertEquals(1, users.count());
        DeleteUserRequest deleteUserRequest = new DeleteUserRequest();
        deleteUserRequest.setUsername("username");
        userServices.deleteUser(deleteUserRequest);
        assertEquals(0, users.count());
    }

    @Test
    public void deleteUserWithoutLoginTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("0902234532");
        userServices.register(registerRequest);
        assertEquals(1, users.count());
        DeleteUserRequest deleteUserRequest = new DeleteUserRequest();
        deleteUserRequest.setUsername("username");
        try {
            userServices.deleteUser(deleteUserRequest);
        }catch (NoteManagerException e){
            assertEquals(e.getMessage(), "log in first");
        }
        assertEquals(1, users.count());
    }

    @Test
    public void deleteNonExistingUserTest(){
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
        assertEquals(1, users.count());
        DeleteUserRequest deleteUserRequest = new DeleteUserRequest();
        deleteUserRequest.setUsername("wrong username");
        try {
            userServices.deleteUser(deleteUserRequest);
        }catch (NoteManagerException e){
            assertEquals(e.getMessage(), "no such user");
        }
        assertEquals(1, users.count());

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
    public void addNonUniqueNoteTest(){
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
        AddNoteRequest addNoteRequest2 = new AddNoteRequest();
        addNoteRequest2.setHeader("first note");
        addNoteRequest2.setContent("note content");
        addNoteRequest2.setAuthor("username");
        try {
            userServices.addNote(addNoteRequest2);
        }
        catch (NoteManagerException e){
            assertEquals(e.getMessage(), "title exists");
        }
        assertEquals(1, notes.count());
    }

    @Test
    public void updateNoteWhileLoggedOutAttempt(){
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
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.setTitle("first note");
        updateRequest.setNewTitle("new note");
        updateRequest.setNewContent("new content");
        updateRequest.setAuthor("username");
        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setUsername("username");
        userServices.logout(logoutRequest);
        try{
            userServices.updateNote(updateRequest);
        }catch (NoteManagerException e){
            assertEquals(e.getMessage(), "log in first");
        }
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
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.setTitle("first note");
        updateRequest.setNewTitle("new note");
        updateRequest.setNewContent("new content");
        updateRequest.setAuthor("username");
        userServices.updateNote(updateRequest);
        assertNotNull(notes.findNoteBy("new note").getId());
        assertEquals(1, notes.count());
    }

    @Test
    public void logoutTest(){
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
        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setUsername("username");
        userServices.logout(logoutRequest);
        assertFalse(users.findByUsername("username").isLoggedIn());
    }
    @Test
    public void logoutWrongUsernameTest(){
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
        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setUsername("wrong username");
        try {
            userServices.logout(logoutRequest);
        }catch (NoteManagerException e){
            assertEquals(e.getMessage(), "no such user");
        }
        assertTrue(users.findByUsername("username").isLoggedIn());
    }

    @Test
    public void deleteNoteTest(){
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
        DeleteNoteRequest deleteRequest = new DeleteNoteRequest();
        deleteRequest.setNoteTitle("first note");
        deleteRequest.setAuthor("username");
        userServices.deleteNote(deleteRequest);
        assertEquals(0, notes.count());
    }

}