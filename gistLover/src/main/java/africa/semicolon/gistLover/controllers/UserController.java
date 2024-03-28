package africa.semicolon.gistLover.controllers;

import africa.semicolon.gistLover.dtos.ApiResponse;
import africa.semicolon.gistLover.dtos.RegisterRequest;
import africa.semicolon.gistLover.exceptions.GistLoverAppException;
import africa.semicolon.gistLover.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import javax.swing.text.html.parser.Entity;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping("/user")
    public ResponseEntity<?> registerWith(RegisterRequest registerRequest){
        try{
            var userMessage = userServices.registerUserWith(registerRequest);
            return new ResponseEntity<>(new ApiResponse(true, userMessage), CREATED);
        }
        catch (GistLoverAppException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
