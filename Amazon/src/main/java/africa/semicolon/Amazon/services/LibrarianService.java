package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.requests.LoginRequest;
import africa.semicolon.Amazon.dtos.requests.LogoutRequest;
import africa.semicolon.Amazon.dtos.requests.RegisterRequest;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;
import africa.semicolon.Amazon.dtos.responses.LoginResponse;
import africa.semicolon.Amazon.dtos.responses.LogoutResponse;
import africa.semicolon.Amazon.dtos.responses.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public interface LibrarianService {

    RegisterResponse register(RegisterRequest readerRequest);

    AddBookResponse addBookWith(AddBookRequest addBookRequest);

    LoginResponse login(LoginRequest loginRequest);

    LogoutResponse logout(LogoutRequest logoutRequest);
}
