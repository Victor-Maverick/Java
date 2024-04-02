package africa.semicolon.Amazon.services;

import africa.semicolon.Amazon.data.model.Reader;
import africa.semicolon.Amazon.data.model.Report;
import africa.semicolon.Amazon.data.repository.Readers;
import africa.semicolon.Amazon.dtos.requests.BorrowRequest;
import africa.semicolon.Amazon.dtos.requests.CreateReaderRequest;
import africa.semicolon.Amazon.dtos.responses.RegisterReaderResponse;
import africa.semicolon.Amazon.exceptions.UsernameExistsException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import static africa.semicolon.Amazon.utils.Mapper.map;

@Service
@RequiredArgsConstructor
public class ReaderServiceImpl implements ReaderSerVices {
    private final Readers readers;
    private final BookServices bookServices;
    @Override
    public RegisterReaderResponse registerReaderWith(CreateReaderRequest readerRequest) {
        Reader reader = new Reader();
        if(isUsernameExisting(readerRequest))throw new UsernameExistsException("Reader exists with that username");
        map(reader, readerRequest);
        readers.save(reader);
        return map(reader);
    }

    @Override
    public Report requestBookWith(BorrowRequest borrowRequest) {
        return bookServices.requestBookWith(borrowRequest);
    }

    private boolean isUsernameExisting(CreateReaderRequest readerRequest){
        List<Reader> readerList = readers.findAll();
        for (Reader reader : readerList){
            if (reader.getUsername().equalsIgnoreCase(readerRequest.getUsername()))return true;
        }
        return false;
    }
}
