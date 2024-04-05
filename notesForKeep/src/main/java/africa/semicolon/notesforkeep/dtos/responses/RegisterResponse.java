package africa.semicolon.notesforkeep.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterResponse {
    private String username;
    private String email;
    private String phoneNumber;
    private LocalDateTime dateRegistered;
}
