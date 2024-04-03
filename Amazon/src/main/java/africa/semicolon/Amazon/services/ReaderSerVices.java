package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Report;
import africa.semicolon.Amazon.dtos.requests.BorrowRequest;
import africa.semicolon.Amazon.dtos.requests.CreateReaderRequest;
import africa.semicolon.Amazon.dtos.requests.IssueRequest;
import africa.semicolon.Amazon.dtos.responses.RegisterReaderResponse;
import org.springframework.stereotype.Service;

@Service
public interface ReaderSerVices {
    RegisterReaderResponse registerReaderWith(CreateReaderRequest readerRequest);

    Report requestBookWith(BorrowRequest borrowRequest);

    Report issueBook(IssueRequest issueRequest);
}
