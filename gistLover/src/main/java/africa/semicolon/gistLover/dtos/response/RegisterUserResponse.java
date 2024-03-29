package africa.semicolon.gistLover.dtos.response;

import lombok.Data;

@Data
public class RegisterUserResponse {
    private String dateRegistered;
    private String id;
    private String username;
}
