package africa.semicolon.notesforkeep.data.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document("User_Table")
public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private boolean isLoggedIn;
    @DBRef
    private List<Note> notes = new ArrayList<>();
    private LocalDateTime dateCreated = LocalDateTime.now();
}
