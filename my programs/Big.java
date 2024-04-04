import java.util.Scanner;
public class Big{

public static void main(String[] args){

Scanner input = new Scanner(System.in);
System.out.println("Enter three integers: ");

int number1 = input.nextInt();
int number2 = input.nextInt();
int number3 = input.nextInt();

int sum = number1 + number2 + number3;
int average = (number1 * number2 * number3)/3;
int product = number1 * number2 * number3;


if (number1 < number2 && number1 < number3)
System.out.printf("%d is the is the smallest num", number1);

if (number 2< number1 && number2 < number3)
System.out.printf("%d is the smallest num", number2);

if (number3 < number2 && number3 < number1)
System.out.printf("%d is the smallest num", number3);



if (number1 > number2 && number1 < number3)
System.out.printf("%d is the is the Largest number", number1);

if (number 2 > number1 && number2 > number3)
System.out.printf("%d is the Largest num", number2);

if (number3 > number2 && number3 > number1)
System.out.printf("%d is the Largest num", number3);



}






}