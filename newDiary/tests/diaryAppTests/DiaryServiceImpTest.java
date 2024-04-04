package diaryAppTests;

import dtos.request.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DiaryServices;
import services.DiaryServicesImp;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
