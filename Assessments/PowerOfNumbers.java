import java.util.Scanner;
  public class PowerOfNumbers{

    public static void main(String[] args){
  
     Scanner input = new Scanner(System.in);
 
     System.out.println("Enter two numbers: ");
     int numberOne = input.nextInt();
     int numberTwo = input.nextInt();
    
    int total = 1;
    for(int i = 0; i <numberTwo; i++){
    total *= numberOne;
    
    }
    System.out.printf("%d raised to %d is: %d", numberOne, numberTwo, total);
    }

}