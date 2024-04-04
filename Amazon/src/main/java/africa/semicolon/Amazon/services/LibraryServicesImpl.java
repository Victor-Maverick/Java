package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Report;
import africa.semicolon.Amazon.dtos.requests.*;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;
import africa.semicolon.Amazon.dtos.responses.LoginResponse;
import africa.semicolon.Amazon.dtos.responses.LogoutResponse;
import africa.semicolon.Amazon.dtos.responses.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static africa.semicolon.Amazon.utils.Mapper.map;

@Service
@RequiredArgsConstructor
public class LibraryServicesImpl implements LibraryServices{
    private final ReaderSerVices readerSerVices;
    private final LibrarianService librarianService;
    @Override
    public AddBookResponse addBookWith(AddBookRequest addBookRequest) {
        return librarianService.addBookWith(addBookRequest);
    }

    @Override
    public RegisterResponse registerReaderWith(RegisterRequest readerRequest) {
        return readerSerVices.registerReaderWith(readerRequest);
    }

    @Override
    public Report requestForBookWith(BorrowRequest borrowRequest) {
        return readerSerVices.requestBookWith(borrowRequest);

    }

    @Override
    public Report issueBook(IssueRequest issueRequest) {
        return readerSerVices.issueBook(issueRequest);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return readerSerVices.login(loginRequest);
    }

    @Override
    public LogoutResponse readerLogout(LogoutRequest logoutRequest) {
        return readerSerVices.logout(logoutRequest);
    }

    @Override
    public RegisterResponse registerLibrarianWith(RegisterRequest readerRequest) {
        return librarianService.register(readerRequest);
    }
}
