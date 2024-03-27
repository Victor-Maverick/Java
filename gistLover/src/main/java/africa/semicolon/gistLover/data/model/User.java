package africa.semicolon.gistLover.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user_list")
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

}
