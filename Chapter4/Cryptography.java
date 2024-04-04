import java.util.Scanner;
    public class Cryptography{

      public static void main(String... args){

      Scanner input = new Scanner(System.in);

      System.out.println("Enter a four-digit number: ");
      int number = input.nextInt();

      int firstDigit = number % 10;
      int firstRemainder = number / 10;
      int secondDigit = firstRemainder % 10;
      int secondRemainder = firstRemainder / 10;
      int thirdDigit = secondRemainder % 10;
      int thirdRemainder = secondRemainder / 10;

        int newDigitOne = (firstDigit + 7) % 10;
	int newDigitTwo = (secondDigit + 7) % 10;
	int newDigitThree = (thirdDigit + 7) % 10;
	int newDigitFour = (thirdRemainder + 7) % 10;
      
      System.out.printf("The encrypted number is %d %d %d %d", newDigitTwo, newDigitOne, newDigitFour, newDigitThree);



      System.out.println("Enter an encrypted number");
      int encryptedNumber = input.nextInt();

      int firstDecrypt = encryptedNumber % 10;
      int Remainder1 = encryptedNumber / 10;
      int secondDecrypt = Remainder1 % 10;
      int Remainder2 = Remainder1 / 10;
      int thirdDecrypt = Remainder2 % 10;
      int Remainder3 = Remainder2 / 10;

      int newDecrypt1 = Remainder3 + 3;
      int newDecrypt2 = thirdDecrypt + 3;
      int newDecrypt3 = secondDecrypt + 3;
      int newDecrypt4 = firstDecrypt + 3;

      System.out.printf("The original number is %d %d %d %d", newDecrypt3, newDecrypt4, newDecrypt1, newDecrypt2);




  }  


}