import java.util.Scanner;
  public class Extremes{

   public static void main(String[] args){

    
    int count = 1;
    int numberOfIntegers = 0;
    Scanner scanner = new Scanner(System.in);
 
    System.out.println("Enter the number of numbers you want to input: ");
    numberOfIntegers = scanner.nextInt();
    
    System.out.println("Enter a number");
    int number = scanner.nextInt();    

    int maximum = number;
    int minimum = number;

    while(count < numberOfIntegers){
     System.out.println("Enter a number: ");
     number = scanner.nextInt();
      if (number > maximum){
       maximum = number;
        }
     if (number < minimum){
       
       minimum = number;
    }
       count++;
    }

    int result = maximum + minimum;
    System.out.printf("the sum of the maximum %d and minimum %d is %d%n", maximum, minimum, result); 


    }
}