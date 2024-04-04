import java.util.Scanner;

public class AccountTest{

public static void main(String... args){

Account account1 = new Account("Victor Orlu", 900.50);
Account account2 = new Account("Peter D", 1000.87);

System.out.printf("%s balance: %.2f%n", account1.getName(), account1.getBalance());
System.out.printf("%s balance: %.2f%n", account2.getName(), account2.getBalance());

Scanner scanner = new Scanner(System.in);

System.out.println("Enter withdrawal amount: ");
double withdrawAmount = scanner.nextDouble();
account1.withdraw(withdrawAmount);

System.out.printf("%s balance: %.2f%n", account1.getName(), account1.getBalance());
System.out.printf("%s balance: %.2f%n", account2.getName(), account2.getBalance());

System.out.println("Enter withdrawal amount for second account: ");
withdrawAmount = scanner.nextDouble();
account2.withdraw(withdrawAmount);

System.out.printf("%s balance: %.2f%n", account1.getName(), account1.getBalance());
System.out.printf("%s balance: %.2f%n", account2.getName(), account2.getBalance());

}




}