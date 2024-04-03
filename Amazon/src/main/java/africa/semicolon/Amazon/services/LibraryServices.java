package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Report;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.requests.BorrowRequest;
import africa.semicolon.Amazon.dtos.requests.CreateReaderRequest;
import africa.semicolon.Amazon.dtos.requests.IssueRequest;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;
import africa.semicolon.Amazon.dtos.responses.RegisterReaderResponse;
import org.springframework.stereotype.Service;

@Service
public interface LibraryServices {

    AddBookResponse addBookWith(AddBookRequest addBookRequest);

    RegisterReaderResponse registerReaderWith(CreateReaderRequest readerRequest);

    Report requestForBookWith(BorrowRequest borrowRequest);

    Report issueBook(IssueRequest issueRequest);
}
