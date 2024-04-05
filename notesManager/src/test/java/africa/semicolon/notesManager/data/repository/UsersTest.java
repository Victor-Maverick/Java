package africa.semicolon.notesManager.data.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class UsersTest {
    @Autowired
    Users users;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void addUserTest(){
    }

}