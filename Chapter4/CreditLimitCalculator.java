import java.util.Scanner;
  public class CreditLimitCalculator{

  public static void main(String... args){

  Scanner scanner = new Scanner(System.in);

  int stop = 0;

  while (stop != -1){

    System.out.println("Enter a customer account number: ");
    String accountNumber = scanner.next();

    System.out.println("Enter the initial balance: ");
    double balance = scanner.nextDouble();

    System.out.println("Enter the total of all items charged by the customer this month");
    int itemsCharged = scanner.nextInt();

    System.out.println("Enter the total of all credits applied to the customer this month");
    int creditsApplied = scanner.nextInt();

    	double newBalance = balance + itemsCharged - creditsApplied;

    	System.out.printf("The new balance is %.1f%n", newBalance);

      	if (newBalance < creditsApplied)
      	 System.out.println("Credit limit exceeded");
      
       	System.out.println("Enter -1 to stop or 2 to continue");
       	stop = scanner.nextInt();
    }
  


  }




}