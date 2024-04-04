import java.util.Scanner;
  public class Lottery{

  public static void main(String... args){

  int lottery = (int)(Math.random() * 100);

  Scanner input = new Scanner(System.in);

  System.out.println("Enter a three digit number");
  int entry = input.nextInt();

  int lotteryNumber1 = lottery % 10;
  int remainder = lottery / 10;
  int lotteryNumber2 = remainder % 10;
  int remainder2 = remainder/10;

  int entryOne = entry % 10;
  int  entryRemainder = entry / 10;
  int entryTwo = entryRemainder % 10;
  int entryRemainder2 = entryRemainder / 10;

  System.out.println("The lottery number is " +lottery);

  if (entryOne == lotteryNumber1 && entryTwo == lotteryNumber2 && remainder2 == entryRemainder2 )
       System.out.println("Your reward is $10,000");
  
  if (entryOne == lotteryNumber2 && entryTwo == lotteryNumber1 && entryRemainder2 == remainder2 || c|| entryOne == remainder2  && entryTwo == lotteryNumber2 && remainder2 == lotteryNumber1 || entryOne == lotteryNumber2 && entryTwo == remainder2 && entryRemainder2 == lotteryNumber1 || entryOne == remainder2 && entryTwo == lotteryNumber1 && entryRemainder2 == lotteryNumber2)
        System.out.println("Your reward is $3,000");

if (entryOne == lotteryNumber1 || entryOne == lotteryNumber2 || entryOne == remainder2 || entryTwo == lotteryNumber1 || entryTwo == entryRemainder || entryRemainder2      	== lotteryNumber1 || entryRemainder2 == lotteryNumber2 || entryRemainder2 == remainder2)
        System.out.println("Your reward is $1,000");



  }








}