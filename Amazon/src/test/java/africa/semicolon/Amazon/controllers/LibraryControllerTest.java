package africa.semicolon.Amazon.controllers;

import africa.semicolon.Amazon.data.repository.Librarians;
import africa.semicolon.Amazon.dtos.requests.RegisterRequest;
import africa.semicolon.Amazon.services.LibraryServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LibraryControllerTest {
    @Autowired
    private LibraryController libraryController;
    @Autowired
    private Librarians librarians;

    @Test
    public void addLibrarianTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryController.registerLibrarian(readerRequest);
        assertEquals(1, librarians.count());
    }

    @Test
    public void addNonUniqueUsernamesTest(){
        RegisterRequest readerRequest = new RegisterRequest();
        readerRequest.setUsername("username");
        readerRequest.setPassword("password");
        readerRequest.setAddress("semicolon Sabo");
        readerRequest.setPhoneNumber("08148624877");
        libraryController.registerLibrarian(readerRequest);
        assertEquals(1, librarians.count());
    }

}