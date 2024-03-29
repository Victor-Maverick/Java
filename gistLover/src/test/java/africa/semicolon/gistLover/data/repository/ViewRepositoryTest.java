package africa.semicolon.gistLover.data.repository;

import africa.semicolon.gistLover.data.model.View;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
public class ViewRepositoryTest {
    @Autowired
    private ViewRepository views;

    @BeforeEach
    public void setup(){
        views.deleteAll();
    }

    @Test
    public void addViewTest(){
        View view = new View();
        views.save(view);
        assertEquals(1,  views.count());

    }
}
