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
@Table(name="Readers_Table")
public class Reader {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String address;
    private String phoneNumber;
    private LocalDateTime dateRegistered = LocalDateTime.now();
}
