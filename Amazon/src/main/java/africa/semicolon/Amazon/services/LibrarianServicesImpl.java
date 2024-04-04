package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Librarian;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.requests.RegisterRequest;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;
import africa.semicolon.Amazon.dtos.responses.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static africa.semicolon.Amazon.utils.Mapper.map;

@Service
@RequiredArgsConstructor
public class LibrarianServicesImpl implements LibrarianService{
    private final BookServices bookServices;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        Librarian librarian = new Librarian();
        librarian.setUsername(registerRequest.getUsername());
        librarian.setPassword(registerRequest.getPassword());
        librarian.setAddress(registerRequest.getAddress());
        return map(librarian);
    }

    @Override
    public AddBookResponse addBookWith(AddBookRequest addBookRequest) {
        return bookServices.addBookWith(addBookRequest);
    }
}
