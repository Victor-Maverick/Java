package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.dtos.requests.BorrowRequest;
import africa.semicolon.Amazon.dtos.requests.CreateReaderRequest;
import africa.semicolon.Amazon.dtos.responses.RegisterReaderResponse;
import org.springframework.stereotype.Service;

@Service
public interface ReaderSerVices {
    RegisterReaderResponse registerReaderWith(CreateReaderRequest readerRequest);

    void requestBookWith(BorrowRequest borrowRequest);
}
