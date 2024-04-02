package africa.semicolon.Amazon.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name="Readers_Table")
public class Reader {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
}
