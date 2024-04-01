package africa.semicolon.gistLover.dtos.request;

import lombok.Data;

@Data
public class DeletePostRequest {
    private String title;
    private String username;
    private String password;
}
