package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Book;
import africa.semicolon.Amazon.data.model.Reader;
import africa.semicolon.Amazon.data.model.Report;
import africa.semicolon.Amazon.data.repository.Books;
import africa.semicolon.Amazon.data.repository.Readers;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.requests.BorrowRequest;
import africa.semicolon.Amazon.dtos.requests.IssueRequest;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;
import africa.semicolon.Amazon.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import static africa.semicolon.Amazon.utils.Mapper.map;

@Service
@RequiredArgsConstructor
public class BookServicesImpl implements BookServices{
    private LibraryServices libraryServices;
    private final Books books;
    private final Readers readers;

    @Override
    public AddBookResponse addBookWith(AddBookRequest addBookRequest) {
        Book book = new Book();
        if (isExistingIsbn(addBookRequest)) throw new IsbnExistsException("book exists with that isb number");
        map(book, addBookRequest);
        books.save(book);
        return map(book);
    }

    @Override
    public Report requestBookWith(BorrowRequest borrowRequest) {
        Book book = books.findBookByTitle(borrowRequest.getTitle());
        if (book == null) throw new NonExistingBookException("no book with that title");
        Reader reader = readers.findByUsername(borrowRequest.getUsername());
        if(reader == null) throw new NonExistentAuthorException("no such author for that book");
        if (!reader.isLoggedIn())throw new ReaderLoginException("log in first");
        if (book.isReserved())throw new ReservedBookException("reserved book");
        book.setReserved(true);
        books.save(book);
        return map(book, borrowRequest);
    }

    @Override
    public Report issueBook(IssueRequest issueRequest) {
        Report report = new Report();
        Book book = books.findBookByTitle(issueRequest.getTitle());
        if (book == null)throw new NonExistingBookException("no such book");
        if (!book.getAuthor().equalsIgnoreCase(issueRequest.getAuthor()))throw new NonExistentAuthorException("wrong author");
        if (!book.isReserved())throw new ReservedBookException("book not reserved");
        book.setReserved(false);
        books.save(book);
        return report;
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
