package africa.semicolon.Amazon.dtos.responses;

import lombok.Data;

@Data
public class LoginResponse {
    private String id;
    private String username;
    private boolean isLoggedIn;
}
