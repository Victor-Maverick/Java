package africa.semicolon.Amazon.controllers;

import africa.semicolon.Amazon.data.model.Report;
import africa.semicolon.Amazon.dtos.requests.*;
import africa.semicolon.Amazon.dtos.responses.ApiResponse;
import africa.semicolon.Amazon.dtos.responses.LoginResponse;
import africa.semicolon.Amazon.exceptions.AmazonAppException;
import africa.semicolon.Amazon.services.LibraryServices;
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

    @PostMapping("/lib-signIn")
    public ResponseEntity<?> signLibrarianIn(@RequestBody LoginRequest loginRequest) {
        try{
            var response = libraryServices.librarianLogin(loginRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }
        catch (AmazonAppException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/libLogOut")
    public ResponseEntity<?> signLibrarianOut(@RequestBody LogoutRequest logoutRequest) {
        try{
            var response = libraryServices.librarianLogout(logoutRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.LOCKED);
        }
        catch (AmazonAppException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add-book")
    public ResponseEntity<?> addBook(@RequestBody AddBookRequest bookRequest){
        try{
            var response = libraryServices.addBookWith(bookRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }
        catch (AmazonAppException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/register-reader")
    public ResponseEntity<?> registerReader(@RequestBody RegisterRequest readerRequest) {
        try {
            var response = libraryServices.registerReaderWith(readerRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }
        catch (AmazonAppException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("reader-logIn")
    public ResponseEntity<?> logReaderIn(LoginRequest loginRequest) {
        try{
            LoginResponse response = libraryServices.logReaderIn(loginRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }
        catch (AmazonAppException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/borrow-book")
    public ResponseEntity<?> borrowBook(BorrowRequest borrowRequest) {
        try{
            Report report = libraryServices.requestForBookWith(borrowRequest);
            return new ResponseEntity<>(new ApiResponse(true, report), HttpStatus.OK);
        }
        catch (AmazonAppException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
