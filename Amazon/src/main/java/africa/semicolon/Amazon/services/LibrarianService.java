package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.dtos.requests.CreateReaderRequest;
import africa.semicolon.Amazon.dtos.responses.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public interface LibrarianService {

    RegisterResponse register(CreateReaderRequest readerRequest);
}
