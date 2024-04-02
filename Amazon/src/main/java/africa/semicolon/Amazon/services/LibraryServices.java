package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.dtos.requests.AddBookRequest;
import africa.semicolon.Amazon.dtos.responses.AddBookResponse;
import org.springframework.stereotype.Service;

@Service
public interface LibraryServices {

    AddBookResponse addBookWith(AddBookRequest addBookRequest);
}
