package africa.semicolon.gistLover.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document("posts")
public class Post {
    private String id;
    private String title;
    private String content;
    private LocalDateTime dateCreated;
    private List<View> views;
    private List<Comment> comments;

}
