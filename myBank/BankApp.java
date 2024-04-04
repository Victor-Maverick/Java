package myBank;


import java.util.Scanner;

import static java.lang.System.exit;

public class BankApp {
    private static Bank bank = new Bank("Chase");
    private static Scanner scanner;



    public static void main(String[] args) {
        gotoMainMenu();
    }

    private static void gotoMainMenu() {
        String choice = """
            Welcome to Chase Bank
            What can we do for you?
            1-> Create Account
            2-> Deposit
            3-> Withdraw
            4-> Transfer
            5-> Check balance
            6-> Delete Account
            7-> Exit
        """;
        String userChoice = input(choice);
        switch (Integer.parseInt(userChoice)){
            case 1:
                register_customer();
            case 2:
                deposit();
            case 3:
                withdraw();
            case 4:
                transfer();
            case 5:
                check_balance();
            case 6:
                delete_account();
            case 7:
                exit(0);
            default:
                gotoMainMenu();

        }
    }

    private static void register_customer() {
        try {
            String firstName = input("Enter your first name: ");
            String lastName = input("Enter your last name: ");
            String setPin = input("Enter a four-digit pin of your choice: ");
            bank.registerCustomer(firstName, lastName, setPin);
            int accountNumber = bank.generateAccountNumber()-1;
            print("Welcome\nYour account number is "+ accountNumber);
        }
        finally {
            gotoMainMenu();
        }
    }

    private static void deposit() {
        String depositAccount = collectAccountNumber();
        String depositAmount = input("How much do you want to deposit? ");
        try {
            bank.deposit(Integer.parseInt(depositAccount), Integer.parseInt(depositAmount));
            print("Successful");
        }
        catch (Exception e){
            print(e.getMessage());
        }
        finally {
            gotoMainMenu();
        }
    }

    private static void withdraw() {
        String withdrawAccount = input("Enter you account number: ");
        String withdrawAmount = input("How much do want to withdraw: ");
        String pin = collectPin();
        try{
            bank.withdraw(Integer.parseInt(withdrawAccount), Integer.parseInt(withdrawAmount), pin);
            print("Successful!!!");
        }
        catch (Exception e){
            print(e.getMessage());
        }
        finally {
            gotoMainMenu();
        }
    }

    private static String collectPin() {
        return input("Enter your pin: ");
    }

    private static void transfer() {
        String fromAccount = collectAccountNumber();
        String toAccount = input("Enter the account number you want to transfer to: ");
        String amount = input("How much do you want to transfer: ");
        String pin = collectPin();
        try {
            bank.transfer(Integer.parseInt(fromAccount), Integer.parseInt(toAccount), Integer.parseInt(amount), pin);
            print("Successful!!!");
        }
        catch (Exception e){
            print(e.getMessage());
        }
        finally {
            gotoMainMenu();
        }
    }

    private static void check_balance() {
        String account = collectAccountNumber();
        String pin = collectPin();
        try{
            int balance = bank.checkBalance(Integer.parseInt(account), pin);
            print("Balance: "+balance);
        }
        catch (Exception e){
            print(e.getMessage());
        }
        finally {
            gotoMainMenu();
        }
    }

    private static void delete_account() {
        String accountNumber = collectAccountNumber();
        String pin = collectPin();
        try{
            bank.removeAccount(Integer.parseInt(accountNumber), pin);
            print("Successful");
        }
        catch(Exception e){
            print(e.getMessage());
        }
        finally {
            gotoMainMenu();
        }
    }


    private static String collectAccountNumber() {
        return input("Enter your account number: ");
    }

    private static String input(String mainMenu){
        print(mainMenu);
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void print(String prompt){
        System.out.println(prompt);
    }
}
