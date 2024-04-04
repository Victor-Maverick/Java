package africa.semicolon.Amazon.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
    private String username;
    private String password;
    private String address;
    private String phoneNumber;
}
