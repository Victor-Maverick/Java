package africa.semicolon.gistLover.data.repository;

import africa.semicolon.gistLover.data.model.User;
import africa.semicolon.gistLover.exceptions.UserExistsException;
import net.bytebuddy.matcher.ElementMatcher;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUserTest(){
        User user = new User();
        var foundUser  = userRepository.save(user);
        assertThat(foundUser.getId(), is(notNullValue()));
        assertThat(userRepository.count(), is(equalTo(1L)));
    }

    @Test
    public void createNonUniqueUser_throwsExceptionTest(){
        User user = new User();
        var foundUser  = userRepository.save(user);
        assertThat(foundUser.getId(), is(notNullValue()));
        assertThat(userRepository.count(), is(equalTo(1L)));
        try{
            assertThrows(UserExistsException.class, ()-> userRepository.save(user));
        }
        catch (UserExistsException e){
            assertEquals(e.getMessage(), "username exists");
        }
    }

}