package diaryAppTests;

import data.exceptions.DiaryAlreadyExistsException;
import dtos.request.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DiaryServices;
import services.DiaryServicesImp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiaryServiceImpTest {
    private DiaryServices diaryService;

    @BeforeEach
    public void setup(){
        diaryService = new DiaryServicesImp();
    }

    @Test
    public void createADiary_listIncreasesTest(){
        RegisterRequest registerRequest = new RegisterRequest("username", "password");
        diaryService.register(registerRequest);
        assertEquals(1L, diaryService.getNumberOfUsers());
    }

    @Test
    public void createTwoDiariesWithSameUsername_throwsExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest("username", "password");
        diaryService.register(registerRequest);
        assertEquals(1L, diaryService.getNumberOfUsers());
        RegisterRequest registerRequest2 = new RegisterRequest("username", "password");
        assertThrows(DiaryAlreadyExistsException.class, ()->diaryService.register(registerRequest2));
        assertEquals(1L, diaryService.getNumberOfUsers());
    }

    @Test
    public void registerTwoDiaries_listOfDiariesIncreasesTest(){
        RegisterRequest registerRequest = new RegisterRequest("username", "password");
        RegisterRequest registerRequest2 = new RegisterRequest("username2", "password");
        diaryService.register(registerRequest);
        diaryService.register(registerRequest2);
        assertEquals(2L, diaryService.getNumberOfUsers());
    }

}
