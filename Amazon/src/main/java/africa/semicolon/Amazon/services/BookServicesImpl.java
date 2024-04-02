package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Book;
import africa.semicolon.Amazon.data.model.Report;
import africa.semicolon.Amazon.data.repository.Books;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.requests.BorrowRequest;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;
import africa.semicolon.Amazon.exceptions.IsbnExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static africa.semicolon.Amazon.utils.Mapper.map;

@Service
@RequiredArgsConstructor
public class BookServicesImpl implements BookServices{
    private final Books books;
    @Override
    public AddBookResponse addBookWith(AddBookRequest addBookRequest) {
        Book book = new Book();
        if (isExistingIsbn(addBookRequest)) throw new IsbnExistsException("book exists");
        map(book, addBookRequest);
        books.save(book);
        return map(book);
    }

    @Override
    public Report requestBookWith(BorrowRequest borrowRequest) {
        List<Book> book = books.findByTitleAndAuthor(borrowRequest.getTitle(), borrowRequest.getAuthor());
        boolean existsByTitle = books.findByAuthor(borrowRequest.getAuthor());
        return null;
    }

    private boolean isExistingIsbn(AddBookRequest addBookRequest){
        for(Book book : books.findAll()){
            if (book.getIsbn().equals(addBookRequest.getIsbn())){
                return true;
            }
            break;
        }
        return false;
    }
}
