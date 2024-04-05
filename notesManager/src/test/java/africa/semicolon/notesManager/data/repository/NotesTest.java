package africa.semicolon.notesManager.data.repository;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;
@DataMongoTest
public class NotesTest {
    @Autowired
    private Notes notes;

    @BeforeEach
    void setUp() {
    }
}