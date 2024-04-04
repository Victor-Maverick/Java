import java.util.Scanner;
public class Palindrome{

public static void main(String... args){

Scanner scanner = new Scanner(System.in);
System.out.println("Enter a three digit number: ");
int firstNumber = scanner.nextInt();


if (firstNumber>=100 && firstNumber <=999){
int numberOne = firstNumber%10;
int remainder = firstNumber/10;
int numberTwo = remainder % 10;
int remainderTwo = remainder / 10;
int numberThree = remainderTwo % 10;
int remainderThree = remainderTwo / 10;

if (numberThree == numberOne){
  System.out.printf("%d is a palindrome number", firstNumber);
 }else{
  System.out.printf("%d is not a palindrome number", firstNumber);
 }


}


}



}