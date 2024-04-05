package africa.semicolon.notesManager.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("User_Table")
public class User {
    private String id;
    private String username;
    private String password;
}
