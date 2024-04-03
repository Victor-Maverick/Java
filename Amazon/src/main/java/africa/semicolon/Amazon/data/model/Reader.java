package africa.semicolon.Amazon.data.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document("Reader_Table")
public class Reader {

    private String id;
    private String username;
    private String password;
    private String address;
    private String phoneNumber;
    private LocalDateTime dateRegistered = LocalDateTime.now();
}
