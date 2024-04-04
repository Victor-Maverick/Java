package africa.semicolon.Amazon.dtos.responses;

import lombok.Data;

@Data
public class LogoutResponse {
    private String username;
    private boolean isLoggedIn;
}
