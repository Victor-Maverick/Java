package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Report;
import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.requests.BorrowRequest;
import africa.semicolon.Amazon.dtos.requests.IssueRequest;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;
import org.springframework.stereotype.Service;

@Service
public interface BookServices {
    AddBookResponse addBookWith(AddBookRequest addBookRequest);
    Report requestBookWith(BorrowRequest borrowRequest);

    Report issueBook(IssueRequest issueRequest);


}
