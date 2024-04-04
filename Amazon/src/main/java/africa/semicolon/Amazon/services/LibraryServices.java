package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Report;
import africa.semicolon.Amazon.dtos.requests.*;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;
import africa.semicolon.Amazon.dtos.responses.LoginResponse;
import africa.semicolon.Amazon.dtos.responses.LogoutResponse;
import africa.semicolon.Amazon.dtos.responses.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public interface LibraryServices {

    AddBookResponse addBookWith(AddBookRequest addBookRequest);

    RegisterResponse registerReaderWith(RegisterRequest readerRequest);

    Report requestForBookWith(BorrowRequest borrowRequest);

    Report issueBook(IssueRequest issueRequest);

    LoginResponse logReaderIn(LoginRequest loginRequest);

    LogoutResponse readerLogout(LogoutRequest logoutRequest);

    RegisterResponse registerLibrarianWith(RegisterRequest readerRequest);

    LoginResponse librarianLogin(LoginRequest loginRequest);

    LogoutResponse librarianLogout(LogoutRequest logoutRequest);
}
