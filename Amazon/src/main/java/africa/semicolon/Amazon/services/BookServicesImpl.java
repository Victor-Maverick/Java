package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Book;
import africa.semicolon.Amazon.data.repository.Books;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.requests.BorrowRequest;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;
import africa.semicolon.Amazon.exceptions.IsbnExistsException;
import africa.semicolon.Amazon.exceptions.NonExistentAuthorException;
import africa.semicolon.Amazon.exceptions.NonExistingBookException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public void requestBookWith(BorrowRequest borrowRequest) {
        Book book = books.findBookByTitle(borrowRequest.getTitle());
        if (book == null) throw new NonExistingBookException("no book with that title");
        if(book.getAuthor().equalsIgnoreCase(borrowRequest.getAuthor()))
            throw new NonExistentAuthorException("no such author for that book");
        book.setReserved(true);
        books.save(book);

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
