package springDiary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import springDiary.exceptions.DiaryAppException;
import springDiary.data.model.Diary;
import springDiary.data.model.Entry;
import springDiary.dtos.request.CreateEntryRequest;
import springDiary.dtos.request.LoginRequest;
import springDiary.dtos.request.RegisterRequest;
import org.springframework.web.bind.annotation.*;
import springDiary.services.DiaryServices;


import java.util.List;
@RestController
@RequestMapping("/user")
public class DiaryController {
    @Autowired
    private DiaryServices diaryServices;


    @PostMapping("/register")
    public String registerWith(@RequestBody RegisterRequest registerRequest) {
        try{
            diaryServices.register(registerRequest);
            return "Diary created successfully";
        }
        catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @GetMapping("/get-users")
    public int getNumberOfUsers() {
        return diaryServices.getNumberOfUsers();
    }

    @PostMapping("/sign-in")
    public String login(@RequestBody LoginRequest loginRequest) {
        try{
            diaryServices.login(loginRequest);
            return "You're logged in!";
        }
        catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @GetMapping("/get-diary-for/{name}")
    public String findBy(@PathVariable("name") String username) {
        try{
            return String.format(String.valueOf(diaryServices.findBy(username)));
        }
        catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @PostMapping("/sign-out/{name}")
    public String logout(@PathVariable("name") String username) {
        try{
            diaryServices.logout(username);
            return "Log out success!!";
        }
        catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @GetMapping("/diary-list")
    public String findAll() {
        try {
            return String.valueOf(diaryServices.findAll());
        }
        catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @DeleteMapping("/delete-diary/{name}")
    public String deleteDiary(@PathVariable("name") String username){
        try{
            diaryServices.deleteDiaryWith(username);
            return "delete success";
        }
        catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @PostMapping("/entry")
    public String addEntryWith(@RequestBody CreateEntryRequest entryRequest) {
        try{
            diaryServices.createEntryWith(entryRequest);
            return "entry created successfully";
        }
        catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @GetMapping("/get-total-entries")
    public int getNumberOfEntries() {
        return diaryServices.findAllEntries().size();
    }

    @DeleteMapping("/delete-entry/{entry-name}/{name}")
    public String deleteWith(@PathVariable("entry-name") String title, @PathVariable("name") String author){
        try{
            diaryServices.deleteEntryBy(title, author);
            return "delete successful";
        }
        catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @GetMapping("/get-all-entries")
    public List<Entry> findAllEntries() {
        return diaryServices.findAllEntries();
    }

    @GetMapping("/getEntriesFor/{name}")
    public String findEntriesFor(@PathVariable("name") String username) {
    try {
        return String.valueOf(diaryServices.findEntriesFor(username));
    }
     catch (DiaryAppException e){
         return e.getMessage();
     }

    }
}
