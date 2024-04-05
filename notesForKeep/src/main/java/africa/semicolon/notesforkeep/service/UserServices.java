package africa.semicolon.notesforkeep.service;

import africa.semicolon.notesforkeep.dtos.request.RegisterRequest;
import africa.semicolon.notesforkeep.dtos.responses.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {

    RegisterResponse register(RegisterRequest registerRequest);
}
