package africa.semicolon.gistLover.dtos.request;

import africa.semicolon.gistLover.data.model.User;
import lombok.Data;

@Data
public class CommentRequest {
    private String title;
    private String comment;
    private String commenterName;


}
