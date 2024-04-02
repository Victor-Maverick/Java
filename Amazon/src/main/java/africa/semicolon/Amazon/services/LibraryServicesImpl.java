package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Book;
import africa.semicolon.Amazon.data.repository.Books;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static africa.semicolon.Amazon.utils.Mapper.map;

@Service
@RequiredArgsConstructor
public class LibraryServicesImpl implements LibraryServices{
    private final Books books;
    @Override
    public AddBookResponse addBookWith(AddBookRequest addBookRequest) {
        Book book = new Book();
        map(book, addBookRequest);
        books.save(book);
        return map(book);
    }
}
