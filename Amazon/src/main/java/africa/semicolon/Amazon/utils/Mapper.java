package africa.semicolon.Amazon.utils;

import africa.semicolon.Amazon.data.model.Book;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;

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
}
