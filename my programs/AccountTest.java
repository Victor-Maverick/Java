import java.util.Scanner;

  public class AccountTest{
  
  public static void main(String... args){

  Account account = new Account();

  Scanner input = new Scanner(System.in);

  System.out.println("Welcome to Maverick Bank");

  System.out.print("Enter your id: ");
  int identity = input.nextInt();
  account.setId(identity);
  account.getId();

  System.out.print("Enter initial balance: ");
  double balance = input.nextDouble();
  account.setBalance(balance);
  account.getBalance();

  System.out.print("Enter annual interest rate: ");
  double annualInterestRate = input.nextDouble();
  account.setAnnualInterestRate(annualInterestRate);
  account.getAnnualInterestRate();
  
  System.out.print("Enter the date created: ");
  String yearCreated = input.next();
 

  System.out.println("Would you like to withdraw? yes or no:  ");
  String decision = input.next();

  if (decision.equals("yes")){
  System.out.print("Enter withdraw amount: ");
  double withdrawAmount = input.nextDouble();
  account.withdraw(withdrawAmount);
  System.out.println("withdraw successful");
  } 

  System.out.println("Would you like to deposit? yes or no: ");
  String choice = input.next();

  if (choice.equals("yes")){
  System.out.print("Enter deposit amount: ");
  double depositAmount = input.nextDouble();
  account.deposit(depositAmount);
  System.out.printf("Your new balance is %.0f", account.getBalance());
  }


System.out.printf("Thank your for banking with us%nYour balance is %.1f%nYour monthly interest is %.1f", account.getBalance(), account.getMonthlyInterest());

  
  






  



  }





}