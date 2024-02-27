package myBank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private  List<Account>accounts = new ArrayList<>();;
    private int noOfAccounts;

    public Bank(String name){
        this.name = name;
    }



    public Account registerCustomer(String firstName, String LastName, String pin) {

        int accountNumber = generateAccountNumber();
        Account account = new Account(firstName + " " + LastName, accountNumber, pin);
        accounts.add(account);
        System.out.println(account.getAccountNumber());

        return account;
    }



    public int generateAccountNumber(){
        return ++noOfAccounts;
    }
    public Account findAccount(int accountNumber) {
        for(Account account : accounts) {
            if (accountNumber == account.getAccountNumber()) {
                return account;
            }
        }
        return null;
    }

    public int checkBalance(int accountNumber, String pin) {
        Account foundAccount = findAccount(accountNumber);
        validateAccount(foundAccount);
        return foundAccount.checkBalance(pin);
    }

    public void deposit(int accountNumber, int depositAmount) {
        Account foundAccount = findAccount(accountNumber);
        validateAccount(foundAccount);
        foundAccount.deposit(depositAmount);
    }

    public void withdraw(int accountNumber, int amount, String pin) {
        Account foundAccount = findAccount(accountNumber);
        validateAccount(foundAccount);
        foundAccount.withdraw(amount, pin);
    }

    public void transfer(int senderAccountNumber, int receiverAccountNumber, int amount, String pin) {
        Account fromAccount = findAccount(senderAccountNumber);
        Account receiverAccount = findAccount(receiverAccountNumber);
        validateAccount(fromAccount);
        validateAccount(receiverAccount);

        fromAccount.withdraw(amount, pin);
        receiverAccount.deposit(amount);

    }

    public void removeAccount(int accountNumber, String number) {
        Account foundAccount = findAccount(accountNumber);
        validateAccount(foundAccount);
        accounts.remove(foundAccount);
    }

    private void validateAccount(Account foundAccount) {
        if(!accounts.contains(foundAccount))throw new InvalidAccountException("Account not found");
    }


}
