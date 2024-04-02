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
@Table(name = "books_list")

public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private boolean isReserved;
    private String author;
    private Integer isbn;
    private Integer quantity;
    private LocalDateTime dateAdded = LocalDateTime.now();

}
