import java.util.Scanner;

public class Interest{

public static void main(String[] args){

Scanner input = new Scanner(System.in);
System.out.println("Enter your balance: ");
int balance = input.nextInt();

System.out.println("Enter your annual percentage interest rate");
double interestRate = input.nextDouble();

int a = balance;
double d = interestRate;
double z = a * (d/1200);
System.out.println("The interest is: " +z);

}






}