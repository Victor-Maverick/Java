import java.util.HashMap;
import java.util.Scanner;
public class PhoneBook{
  private static final Scanner input = new Scanner(System.in);
  private final HashMap<String, String> phoneContacts = new HashMap<String, String>();
    public int displayPhoneBookMenu(){

        System.out.println("""
        Welcome to ePhoneBook
        
        1. Create contact
        2. Display contacts
        3. Search contact
        4. Delete contact
        5. exit
        
        Choose an option to select action(1, 2, 3, 4):
        
        """);

        int choice = input.nextInt();

        return choice;
    }

    public HashMap displayContacts(){

        for (String contacts : phoneContacts.keySet()) {

            System.out.println("Name: " + contacts + "\n"+"Phone No: " + phoneContacts.get(contacts) +"\n");

        }
        return phoneContacts;
    }

    public String addContactToPhoneBook(String name, String phoneNumber){

        phoneContacts.put(name, phoneNumber);

        return phoneContacts.get(name);
    }

    public String deleteContactFromPhoneBook(String key){

        phoneContacts.remove(key);
        return phoneContacts.get(key);

    }

    public String dialNumber(String key){

        return String.format("Calling>>> %n%s%n%s", key, phoneContacts.get(key));

    }

    public boolean checkForContactInPhoneBook(String key){

        return phoneContacts.containsKey(key);

    }
}