package africa.semicolon.gistLover.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("comment_list")
public class Comment {
    private String id;
    private String comment;
    private User commenter;
    private LocalDateTime timeOfComment;
}
