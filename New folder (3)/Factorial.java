import java.util.Scanner;

public class Factorial{

  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

      System.out.println("Enter any positive number between 1 and 20: ");
      int number = scanner.nextInt();
  
      while(number < 1 || number > 20){

        System.out.println("Enter any positive number between 1 and 20: ");
        number = scanner.nextInt();

      }

      int factorial = 1;
      for(int count = number; count > 0; count--){

	factorial *= count; 
      }
      System.out.printf("The factorial of %d is %d%n", number, factorial);
  }

}