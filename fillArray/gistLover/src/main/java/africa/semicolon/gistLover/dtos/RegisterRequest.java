package africa.semicolon.gistLover.dtos;

import lombok.Data;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
}
