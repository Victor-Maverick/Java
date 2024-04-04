package africa.semicolon.Amazon.utils;

import africa.semicolon.Amazon.data.model.Book;
import africa.semicolon.Amazon.data.model.Librarian;
import africa.semicolon.Amazon.data.model.Reader;
import africa.semicolon.Amazon.data.model.Report;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.requests.BorrowRequest;
import africa.semicolon.Amazon.dtos.requests.RegisterRequest;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;
import africa.semicolon.Amazon.dtos.responses.LoginResponse;
import africa.semicolon.Amazon.dtos.responses.LogoutResponse;
import africa.semicolon.Amazon.dtos.responses.RegisterResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {
    public static void map(Book book, AddBookRequest bookRequest){
        book.setTitle(bookRequest.getBookTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setIsbn(bookRequest.getIsbn());
    }

    public static AddBookResponse map(Book book){
        AddBookResponse bookResponse = new AddBookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setTitle(book.getTitle());
        bookResponse.setAuthor(book.getAuthor());
        bookResponse.setIsbn(book.getIsbn());
        bookResponse.setDateAdded(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(book.getDateAdded()));
        return bookResponse;
    }

    public static RegisterResponse map(Reader reader){
        RegisterResponse readerResponse = new RegisterResponse();
        readerResponse.setId(reader.getId());
        readerResponse.setUsername(reader.getUsername());
        readerResponse.setPhoneNumber(readerResponse.getPhoneNumber());
        readerResponse.setDateCreated(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(reader.getDateRegistered()));
       return readerResponse;
    }

    public static void map(Reader reader, RegisterRequest readerRequest){
        reader.setUsername(readerRequest.getUsername());
        reader.setPassword(readerRequest.getPassword());
        reader.setAddress(readerRequest.getAddress());
        reader.setPhoneNumber(readerRequest.getPhoneNumber());
    }

    public static Report map(Book book, BorrowRequest borrowRequest){
        Report report = new Report();
        report.setId(book.getId());
        report.setBookTitle(book.getTitle());
        report.setUsername(borrowRequest.getUsername());
        report.setIssueDate(LocalDateTime.now());
        report.setReturnDate(report.getIssueDate().plusDays(5));
        return report;
    }

    public static LoginResponse mapLogin(Reader reader){
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(reader.getId());
        loginResponse.setUsername(reader.getUsername());
        loginResponse.setLoggedIn(reader.isLoggedIn());
        return loginResponse;
    }

    public static LogoutResponse mapLogout(Reader reader){
        LogoutResponse logoutResponse = new LogoutResponse();
        logoutResponse.setUsername(reader.getUsername());
        logoutResponse.setLoggedIn(reader.isLoggedIn());
        return logoutResponse;
    }

    public static RegisterResponse map(Librarian librarian){
        RegisterResponse response = new RegisterResponse();
        response.setId(librarian.getId());
        response.setUsername(librarian.getUsername());
        response.setDateCreated(DateTimeFormatter.ofPattern("mm/MM/yyyy").format(LocalDateTime.now()));
        response.setPhoneNumber(librarian.getPhoneNumber());
        return response;
    }

    public static LoginResponse mapLogin(Librarian librarian){
        LoginResponse response = new LoginResponse();
        response.setUsername(librarian.getUsername());
        response.setLoggedIn(librarian.isLoggedIn());
        return response;
    }
    public static LogoutResponse logoutMap(Librarian librarian){
        LogoutResponse response = new LogoutResponse();
        response.setUsername(librarian.getUsername());
        response.setLoggedIn(librarian.isLoggedIn());
        return response;
    }

}
