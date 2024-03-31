package africa.semicolon.gistLover.dtos.response;

import lombok.Data;

@Data
public class CommentResponse {
    private String id;
    private String content;
    private String dateCreated;
}
