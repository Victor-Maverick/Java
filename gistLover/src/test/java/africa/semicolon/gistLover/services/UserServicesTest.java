package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.repository.UserRepository;
import africa.semicolon.gistLover.dtos.RegisterRequest;
import africa.semicolon.gistLover.exceptions.NonExistingUserException;
import africa.semicolon.gistLover.exceptions.UserExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServicesTest {

    @Autowired
    private UserServices userServices;
    @Autowired
    private UserRepository userRepository;

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
        userServices.registerUserWith(registerRequest);
        assertEquals(1, userRepository.count());
    }

    @Test
    public void createNonUniqueUser_throwsExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userServices.registerUserWith(registerRequest);
        try{
            userServices.registerUserWith(registerRequest);
        }
        catch (UserExistsException e){
            assertEquals(e.getMessage(), "username already exists");
        }
        assertEquals(1, userRepository.count());
    }

    @Test
    public void deleteUserTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userServices.registerUserWith(registerRequest);
        userServices.deleteBy("username");
        assertEquals(0, userRepository.count());
    }

    @Test
    public void deleteNonExistingUser_throwsExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstname");
        registerRequest.setLastName("lastname");
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        userServices.registerUserWith(registerRequest);
        try {
            userServices.deleteBy("wrong username");
        }
        catch (NonExistingUserException e){
            assertEquals(e.getMessage(), "non existing user");
        }
        assertEquals(1, userRepository.count());
    }

}