import java.util.Scanner;
public class MultiplicationTable{

  public static void main(String[] args){
    
    Scanner scr = new Scanner(System.in);
    
      System.out.println("Enter a number of your choice: ");
      int number = scr.nextInt();

      while(number < 1){
        System.out.println("Enter an integer greater than 0: ");
        number = scr.nextInt();
      }

      for(int count = 1; count <= 100; count++){

	System.out.printf("%d x %d = %d%n", number, count, (number * count));
      }
  }

}