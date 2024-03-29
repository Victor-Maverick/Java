package africa.semicolon.gistLover.controllers;

import africa.semicolon.gistLover.data.repository.UserRepository;
import africa.semicolon.gistLover.dtos.RegisterRequest;
import africa.semicolon.gistLover.exceptions.GistLoverAppException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    UserController userController;
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setup(){
        userRepository.deleteAll();
    }
    @Test
    public void createUserTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userController.registerWith(registerRequest);
        assertThat(userRepository.count(), is(equalTo(1L)));
    }

    @Test
    public void createNonUniqueUser_throwExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userController.registerWith(registerRequest);
        try{
            userController.registerWith(registerRequest);
        }
        catch (GistLoverAppException e){
            assertEquals(e.getMessage(), "username already exists");
        }
        assertThat(userRepository.count(), is(equalTo(1L)));
    }

    @Test
    public void deleteUserTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userController.registerWith(registerRequest);
        assertThat(userRepository.count(), is(equalTo(1L)));
        userController.deleteUserWith("username");
        assertThat(userRepository.count(), is(equalTo(0L)));
    }

}
