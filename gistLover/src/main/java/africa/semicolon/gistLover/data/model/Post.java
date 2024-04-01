package africa.semicolon.gistLover.data.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document("posts")
public class Post {
    private String id;
    private String title;
    private String content;
    private User author;
    private LocalDateTime dateCreated = LocalDateTime.now();
    @DBRef
    private List<View> views = new ArrayList<>();
    @DBRef
    private List<Comment> comments = new ArrayList<>();


}
