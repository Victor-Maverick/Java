import java.util.Scanner;

  public class SpecifiedSum{

  public static void main(String[] args){
  Scanner scanner = new Scanner(System.in);
 
  System.out.println("Enter a number");
  int numberOne = scanner.nextInt();

  int total = 0;
  while (total < numberOne){
  System.out.println("Enter number: ");
  int number = scanner.nextInt();

   total = total + number;

  }

  }


  }