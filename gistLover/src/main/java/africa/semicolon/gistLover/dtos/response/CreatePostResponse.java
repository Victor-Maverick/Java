package africa.semicolon.gistLover.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreatePostResponse {
    private String title;
    private String id;
    private String dateCreated;

}
