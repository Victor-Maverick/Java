package africa.semicolon.Amazon.data.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@EqualsAndHashCode(callSuper = true)
@Data
@Document("Reader_Table")
public class Reader extends User{
    private Report report;
}
