package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Book;
import africa.semicolon.Amazon.data.model.Report;
import africa.semicolon.Amazon.data.repository.Books;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.requests.BorrowRequest;
import africa.semicolon.Amazon.dtos.requests.CreateReaderRequest;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;
import africa.semicolon.Amazon.dtos.responses.RegisterReaderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static africa.semicolon.Amazon.utils.Mapper.map;

@Service
@RequiredArgsConstructor
public class LibraryServicesImpl implements LibraryServices{
    private final Books books;
    private final BookServices bookServices;
    private final ReaderSerVices readerSerVices;
    @Override
    public AddBookResponse addBookWith(AddBookRequest addBookRequest) {
        return bookServices.addBookWith(addBookRequest);
    }

    @Override
    public RegisterReaderResponse registerReaderWith(CreateReaderRequest readerRequest) {
        return readerSerVices.registerReaderWith(readerRequest);
    }

    @Override
    public Report requestForBookWith(BorrowRequest borrowRequest) {
        return readerSerVices.requestBookWith(borrowRequest);
    }
}
