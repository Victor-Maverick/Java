import java.util.Scanner;
  public class Palindrome{

   public static void main(String... args){

   Scanner scanner = new Scanner(System.in);

   int number = 0;

   System.out.println("Enter a 5-digit number: ");
     number = scanner.nextInt();
    
   while(number<10000 || number > 99999){
         System.out.println("Error with input, please input a number with 5 digits");
           number = scanner.nextInt();}

   
   if  (number >= 10000 && number < 100000){
  
    int firstDigit = number % 10;
    int firstRemainder = number / 10;
    int secondDigit = firstRemainder % 10;
    int secondRemainder = firstRemainder / 10;
    int thirdDigit = secondRemainder % 10;
    int thirdRemainder = secondRemainder / 10;
    int fourthDigit = thirdRemainder % 10;
    int fourthRemainder = thirdRemainder / 10;

      if (firstDigit == fourthRemainder && secondDigit == fourthDigit){
        System.out.printf("%d is a palindrome number", number);
      }else{
            System.out.printf("%d is not a palindrome number", number);
            }
}    
   
     
        





   }










  }