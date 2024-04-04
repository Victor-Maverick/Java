import java.util.Scanner;
import java.security.SecureRandom;

 public class Random{

  public static void main(String[] args){

  SecureRandom random = new SecureRandom();
  int number = random.nextInt(1,11);

  Scanner input = new Scanner(System.in);

  System.out.println("guess a number from 1 - 10");
  int guess = input.nextInt();

  while (guess < 0 || guess > 10){
   System.out.println("guess a number from 1-10 only");
   guess = input.nextInt();
  
  if (guess > 0 && guess <=10){
  if (number == guess){
   System.out.printf("correct: random number = %d %nyour guess = %d ", number, guess);
   }
   else if(number > guess){
    System.out.printf("Too low: random number = %d %nyour guess = %d ", number, guess);
   }
   else{
      System.out.printf("Too high: random number = %d %nyour guess = %d ", number, guess);
   }

   }

   }

   }




}
