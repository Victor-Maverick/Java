package africa.semicolon.gistLover.controllers;

import africa.semicolon.gistLover.dtos.response.ApiResponse;
import africa.semicolon.gistLover.dtos.request.RegisterRequest;
import africa.semicolon.gistLover.exceptions.GistLoverAppException;
import africa.semicolon.gistLover.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping("/user")
    public ResponseEntity<?> registerWith(@RequestBody RegisterRequest registerRequest){
        try{
            var userMessage = userServices.registerUserWith(registerRequest);
            return new ResponseEntity<>(new ApiResponse(true, userMessage), CREATED);
        }
        catch (GistLoverAppException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUserWith(@PathVariable("username") String username) {
        try{
            var deleteMessage = userServices.deleteBy(username);
            return new ResponseEntity<>(new ApiResponse(true, deleteMessage), HttpStatus.OK);
        }
        catch (GistLoverAppException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
