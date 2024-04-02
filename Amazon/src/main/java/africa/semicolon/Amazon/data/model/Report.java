package africa.semicolon.Amazon.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name ="Reports")
public class Report {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer book_id;
    private LocalDateTime issueDate;
    private LocalDateTime returnDate;
}
