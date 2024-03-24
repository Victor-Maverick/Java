package springDiary.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
public class Entry {
    private String id;
    private String title;
    private String body;
    private LocalDate dateCrated;
    private String author;





}
