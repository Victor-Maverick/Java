package africa.semicolon.gistLover.dtos.request;

import lombok.Data;

@Data
public class DeleteCommentRequest {
    private String comment;
    private String title;
    private String userName;
}
