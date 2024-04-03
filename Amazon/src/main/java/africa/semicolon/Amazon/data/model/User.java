package africa.semicolon.Amazon.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private boolean isLoggedIn;
    private String address;
    private String phoneNumber;
    private LocalDateTime dateRegistered = LocalDateTime.now();
    private Report report;
}
