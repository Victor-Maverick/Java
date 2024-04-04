package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Librarian;
import africa.semicolon.Amazon.data.repository.Librarians;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.requests.LoginRequest;
import africa.semicolon.Amazon.dtos.requests.LogoutRequest;
import africa.semicolon.Amazon.dtos.requests.RegisterRequest;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;
import africa.semicolon.Amazon.dtos.responses.LoginResponse;
import africa.semicolon.Amazon.dtos.responses.LogoutResponse;
import africa.semicolon.Amazon.dtos.responses.RegisterResponse;
import africa.semicolon.Amazon.exceptions.IncorrectPasswordException;
import africa.semicolon.Amazon.exceptions.NonExistentUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static africa.semicolon.Amazon.utils.Mapper.*;

@Service
@RequiredArgsConstructor
public class LibrarianServicesImpl implements LibrarianService{
    private final BookServices bookServices;
    private final Librarians librarians;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        Librarian librarian = new Librarian();
        librarian.setUsername(registerRequest.getUsername());
        librarian.setPassword(registerRequest.getPassword());
        librarian.setPhoneNumber(registerRequest.getPhoneNumber());
        librarian.setAddress(registerRequest.getAddress());
        librarians.save(librarian);
        return map(librarian);
    }

    @Override
    public AddBookResponse addBookWith(AddBookRequest addBookRequest) {
        return bookServices.addBookWith(addBookRequest);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Librarian librarian = librarians.findByUsername(loginRequest.getUsername());
        if (librarian == null)throw new NonExistentUserException("no such staff");
        if (!librarian.getPassword().equals(loginRequest.getPassword()))throw new IncorrectPasswordException("wrong password");
        librarian.setLoggedIn(true);
        librarians.save(librarian);
        return mapLogin(librarian);
    }

    @Override
    public LogoutResponse logout(LogoutRequest logoutRequest) {
        Librarian librarian = librarians.findByUsername(logoutRequest.getUsername());
        if (librarian == null)throw new NonExistentUserException("no such staff");
        librarian.setLoggedIn(false);
        librarians.save(librarian);
        return logoutMap(librarian);
    }
}
