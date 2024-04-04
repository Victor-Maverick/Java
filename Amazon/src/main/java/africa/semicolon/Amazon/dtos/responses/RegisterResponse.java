package africa.semicolon.Amazon.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterResponse {
    private String id;
    private String username;
    private String phoneNumber;
    private String dateCreated;
}
