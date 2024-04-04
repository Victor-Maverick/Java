package africa.semicolon.Amazon.dtos.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String address;
    private String phoneNumber;
}
