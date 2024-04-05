package africa.semicolon.notesforkeep.data.repository;

import africa.semicolon.notesforkeep.data.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;
@DataMongoTest
public class UsersTest {
    @Autowired
    Users users;
    @BeforeEach
    public void setUp() {
        users.deleteAll();
    }

    @Test
    public void saveUserTest(){
        User user = new User();
        users.save(user);
        assertEquals(1, users.count());
    }

}