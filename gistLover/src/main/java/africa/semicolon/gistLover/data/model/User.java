package africa.semicolon.gistLover.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document("user_list")
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    @DBRef
    private List<Post> posts;
    private LocalDateTime dateCreated = LocalDateTime.now();

}
