package africa.semicolon.Amazon.utils;

import africa.semicolon.Amazon.data.model.Book;
import africa.semicolon.Amazon.data.model.Reader;
import africa.semicolon.Amazon.data.model.Report;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.requests.BorrowRequest;
import africa.semicolon.Amazon.dtos.requests.CreateReaderRequest;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;
import africa.semicolon.Amazon.dtos.responses.LoginResponse;
import africa.semicolon.Amazon.dtos.responses.RegisterReaderResponse;

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

    public static RegisterReaderResponse map(Reader reader){
        RegisterReaderResponse readerResponse = new RegisterReaderResponse();
        readerResponse.setId(reader.getId());
        readerResponse.setUsername(reader.getUsername());
        readerResponse.setPhoneNumber(readerResponse.getPhoneNumber());
        readerResponse.setDateCreated(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(reader.getDateRegistered()));
       return readerResponse;
    }

    public static void map(Reader reader, CreateReaderRequest readerRequest){
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

}
