import java.util.Scanner;
public class PhoneBook1 {
    private Scanner scanner = new Scanner(System.in);
    PhoneBook phoneBook1 = new PhoneBook();

    public void getPhoneBook(){

        int decision = phoneBook1.displayPhoneBookMenu();

        switch (decision){
            case 1:
                String phoneNumber = collectPhoneNumber();
                String name = getName();
                System.out.println("Saving >>>>>>>>>>>>>>>>\nSuccessfully saved\n" + name);
                phoneBook1.addContactToPhoneBook(name, phoneNumber);

                break;
            case 2:
                phoneBook1.displayContacts();

                break;
            case 3:
                phoneBook1.displayContacts();
                String nameToSearch = collectNameToCheckNumber();
                phoneBook1.checkForContactInPhoneBook(nameToSearch);
                System.out.println("select an option\n1 Call\n2 Exit");
                int options = scanner.nextInt();
                switch (options){
                    case 1:
                        phoneBook1.dialNumber(nameToSearch);
                        break;
                    case 2:
                        break;
                }
                break;
            case 4:
                String key = collectNameToDelete();
                if(phoneBook1.checkForContactInPhoneBook(key)) {

                    phoneBook1.deleteContactFromPhoneBook(key);
                    System.out.println("Deleting >>>>>>>>>>>>>>>>\nSucesfully deleted\n" + key);
                }
                else{
                    System.out.println(key + "is not in your contact list");
                }

                break;
            case 5:
                break;
            default:
                getPhoneBook();

        }
        int choice =  displayOptions();
        switch (choice){
            case 1:
                getPhoneBook();
                break;
            case 2:
                break;

        }

    }

    public String getNameToCall(){

        System.out.println("enter name of contact you wish to dial: ");
        String contactName = scanner.next();

        return contactName;
    }

    public String getName(){

        System.out.println("Enter a name for the contact you want to save: ");
        String contactName = scanner.next();

        return contactName;
    }

    public String collectPhoneNumber(){

        System.out.println("Enter the phone number of the contact you want to save: ");
        String contactNumber = scanner.next();

        return contactNumber;

    }

    public String collectNameToCheckNumber(){

        System.out.println("Enter the contact you want to search: ");
        String keyToSearch = scanner.next();

        return keyToSearch;
    }

    public String collectNameToDelete(){

        System.out.println("Enter the contact you want to delete: ");
        String keyToDelete = scanner.next();

        return keyToDelete;

    }

    public int displayOptions(){

        System.out.println("Select an option\n1 Back to main\n2 exit");
        int choice = scanner.nextInt();

        return choice;
    }

}
