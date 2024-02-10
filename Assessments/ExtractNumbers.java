import java.util.Scanner;
public class ExtractNumbers{
public static void main(String[] args){
Scanner quiba = new Scanner(System.in);
System.out.println("Enter a number which has 5 digits ");
int number = quiba.nextInt();
int firstNumber = number / 10000;
int firstRemainder = number % 10000;
int secondNumber = firstRemainder / 1000;
int secondRemainder = firstRemainder % 1000;
int thirdNumber = secondRemainder / 100;
int thirdRemainder = secondRemainder % 100;
int fourthNumber = thirdRemainder /10;
int fourthRemainder = thirdRemainder % 10;
int fifthNumber = fourthRemainder / 1;
int fifthRemainder = fourthRemainder % 10;

System.out.printf("%d  %d  %d  %d  %d ", firstNumber, secondNumber, thirdNumber, fourthNumber, fifthNumber);


}

}