import java.util.Scanner;
public class Seperate{

public static void main(String[] args){
Scanner scanner = new Scanner(System.in);
System.out.println("Enter a number with 5 digits");
int num = scanner.nextInt();

int firstDigit = num / 10000;
int firstRemainder = num % 10000;
int secondDigit=firstRemainder/1000;
int secondRemainder=firstRemainder%1000;
int thirdDigit=secondRemainder/100;
int thirdRemainder=secondRemainder%100;
int fourthDigit=thirdRemainder/10;
int fourthRemainder=thirdRemainder%10;
int fifthDigit=fourthRemainder/1;
int fifthRemainder=fourthRemainder/1;

System.out.printf("%d %d %d %d %d", firstDigit, secondDigit, thirdDigit, fourthDigit, fifthDigit);


}






}