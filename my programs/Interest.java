import java.util.Scanner;

public class Interest{

public static void main(String[] args){

Scanner input = new Scanner(System.in);
System.out.println("Enter your balance: ");
int balance = input.nextInt();

System.out.println("Enter your annual percentage interest rate");
double interestRate = input.nextDouble();


double interest = balance * (interestRate / 1200);
System.out.println("The interest is: " +interest);

}






}