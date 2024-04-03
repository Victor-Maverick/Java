package africa.semicolon.Amazon.data.model;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("Book_Table")
public class Book {
    private String id;
    private String title;
    private boolean isReserved;
    private String author;
    private Integer isbn;
    private Integer quantity;
    private LocalDateTime dateAdded = LocalDateTime.now();

}
