package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Report;
import africa.semicolon.Amazon.dtos.requests.*;
import africa.semicolon.Amazon.dtos.responses.LoginResponse;
import africa.semicolon.Amazon.dtos.responses.LogoutResponse;
import africa.semicolon.Amazon.dtos.responses.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public interface ReaderSerVices {
    RegisterResponse registerReaderWith(CreateReaderRequest readerRequest);

    Report requestBookWith(BorrowRequest borrowRequest);

    Report issueBook(IssueRequest issueRequest);

    LoginResponse login(LoginRequest loginRequest);

    LogoutResponse logout(LogoutRequest logoutRequest);
}
