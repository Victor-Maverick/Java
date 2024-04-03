package africa.semicolon.Amazon.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("Report_Table")
public class Report {

    private String id;
    private String book_id;
    private LocalDateTime issueDate;
    private LocalDateTime returnDate;
}
