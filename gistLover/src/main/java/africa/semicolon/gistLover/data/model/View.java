package africa.semicolon.gistLover.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("views_table")
public class View {
    private String id;
    private User viewer;
    private LocalDateTime timeOfView = LocalDateTime.now();

}
