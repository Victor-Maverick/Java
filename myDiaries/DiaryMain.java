package myDiaries;

import myBank.InvalidPinException;
import myDiaries.Exceptions.IncorrectPasswordException;

import java.util.Scanner;

import static java.lang.System.exit;

public class DiaryMain {
    private static Diary diary;
    private static Diaries diaries = new Diaries();

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        String decision = """
                            Welcome!!!
                   what would you like to do?
                1-> Create Diary
                2-> Unlock Diary
                3-> Lock Diary
                4-> Add Entry
                5-> Update Entry
                6-> Find Entry by id
                7-> Delete Entry
                8-> Exit
                """;
        String userChoice = input(decision);
        switch (Integer.parseInt(userChoice)){
            case 1:
                createDiary();
            case 2:
                unlockDiary();
            case 3:
                lockDiary();
            case 4:
                addEntry();
            case 5:
                updateEntry();
            case 6:
                findEntryById();
            case 7:
                deleteEntry();
            case 8:
                exit(0);
            default:
                mainMenu();
        }
    }

    private static void deleteEntry() {
        String id = input("Enter the entry number");
        try{
            diary.deleteEntry(Integer.parseInt(id));
        }
        finally{
            mainMenu();
        }
    }

    private static void findEntryById() {
        String id = input("Enter the entry number");
        try{
            diary.findEntryById(Integer.parseInt(id));
        }
        finally {
            mainMenu();
        }
    }

    private static void updateEntry() {
        String id = input("Enter the entry id: ");
        String title = input("Write the new title you want updated to: ");
        String body = input("Write the new body you want to update: ");
        try{
            diary.updateEntry(Integer.parseInt(id), title, body);
        }
        finally {
            mainMenu();
        }
    }

    private static void addEntry() {
        String title = input("Enter a title for your new entry: ");
        String body = input("Write the body of your entry\n");
        try {
            diary.createEntry(title, body);
        }
        finally {
            mainMenu();
        }
    }

    private static void lockDiary() {
        try {
            diary.lockDiary();
        }
        finally {
            mainMenu();
        }
    }

    private static void unlockDiary() {
        String password = input("Enter password to unlock: ");
        try {
            diary.unlockDiary(password);
        }
        catch (IncorrectPasswordException e){
            print(e.getMessage());
        }
        finally {
            mainMenu();
        }
    }

    private static void createDiary() {
        String username = input("Enter a username of your choice");
        String password = input("Enter a password of your choice");
        try{
            diary = new Diary(username, password);
            diaries.add(username, password);
        }
        finally {
            mainMenu();
        }
    }

    private static String input(String menu) {
        print(menu);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void print(String menu) {
        System.out.println(menu);
    }
}
