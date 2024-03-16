package services;

import dtos.request.RegisterRequest;

public interface DiaryServices {
    
    void register(RegisterRequest registerRequest);
    void login();


    int getNumberOfUsers();
}
