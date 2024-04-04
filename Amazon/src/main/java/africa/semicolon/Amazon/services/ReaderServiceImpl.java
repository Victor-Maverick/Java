package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Reader;
import africa.semicolon.Amazon.data.model.Report;
import africa.semicolon.Amazon.data.repository.Readers;
import africa.semicolon.Amazon.dtos.requests.*;
import africa.semicolon.Amazon.dtos.responses.LoginResponse;
import africa.semicolon.Amazon.dtos.responses.LogoutResponse;
import africa.semicolon.Amazon.dtos.responses.RegisterResponse;
import africa.semicolon.Amazon.exceptions.IncorrectPasswordException;
import africa.semicolon.Amazon.exceptions.NonExistentUserException;
import africa.semicolon.Amazon.exceptions.UsernameExistsException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import static africa.semicolon.Amazon.utils.Mapper.*;

@Service
@RequiredArgsConstructor
public class ReaderServiceImpl implements ReaderSerVices {
    private final Readers readers;
    private final BookServices bookServices;

    @Override
    public RegisterResponse registerReaderWith(RegisterRequest readerRequest) {
        Reader reader = new Reader();
        if(isUsernameExisting(readerRequest))throw new UsernameExistsException("Reader exists with that username");
        map(reader, readerRequest);
        readers.save(reader);
        return map(reader);
    }

    @Override
    public Report requestBookWith(BorrowRequest borrowRequest) {
        return bookServices.requestBookWith(borrowRequest);

    }

    @Override
    public Report issueBook(IssueRequest issueRequest) {
        return bookServices.issueBook(issueRequest);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Reader reader = readers.findByUsername(loginRequest.getUsername());
        validateUsername(reader);
        validatePassword(loginRequest, reader);
        reader.setLoggedIn(true);
        readers.save(reader);
        return mapLogin(reader);
    }

    @Override
    public LogoutResponse logout(LogoutRequest logoutRequest) {
        Reader reader = readers.findByUsername(logoutRequest.getUsername());
        validateUsername(reader);
        reader.setLoggedIn(false);
        readers.save(reader);
        return mapLogout(reader);
    }

    private static void validateUsername(Reader reader) {
        if (reader == null)throw new NonExistentUserException("user does not exist with that username");
    }

    private static void validatePassword(LoginRequest loginRequest, Reader reader) {
        if(!reader.getPassword().equals(loginRequest.getPassword()))throw new IncorrectPasswordException("wrong password");
    }

    private boolean isUsernameExisting(RegisterRequest readerRequest){
        List<Reader> readerList = readers.findAll();
        for (Reader reader : readerList){
            if (reader.getUsername().equalsIgnoreCase(readerRequest.getUsername()))return true;
        }
        return false;
    }
}
