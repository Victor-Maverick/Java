package africa.semicolon.Amazon.controllers;

import africa.semicolon.Amazon.dtos.requests.RegisterRequest;
import africa.semicolon.Amazon.dtos.responses.ApiResponse;
import africa.semicolon.Amazon.exceptions.AmazonAppException;
import africa.semicolon.Amazon.services.LibraryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lib")
public class LibraryController {
    @Autowired
    private LibraryServices libraryServices;


    @PostMapping("/register-staff")
    public ResponseEntity<?> registerLibrarian(@RequestBody RegisterRequest readerRequest) {
        try {
            var response = libraryServices.registerLibrarianWith(readerRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }
        catch (AmazonAppException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
