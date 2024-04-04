import java.util.Scanner;
  public class LargestNumber{
  
  public static void main(String... args){

  Scanner scanner = new Scanner(System.in);

  int largest = 0;
  int counter = 1;  
  int number = 0;

  while (counter <= 10){
  System.out.println("Enter a number");
  number = scanner.nextInt();
  if (number > largest){
    largest = number;
   }
   counter+=1;
   
  }

  System.out.printf("%d is the largest%n", largest);
  System.out.printf("%d is the number most recently entered%n", number);




  }
}