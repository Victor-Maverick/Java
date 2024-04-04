import java.util.Scanner;
  public class CountsOfZeroPositiveNegative{

    public static void main(String[] args){
  
     Scanner input = new Scanner(System.in);
     
     int negativeCount = 0;
     int positiveCount = 0;
     int zeroCount = 0;
     int counter = 0;

      System.out.println("Enter a number or -1 to quit: ");
      int number = input.nextInt();

       while (number != -1){
        if(number == -1){
        System.out.print("No numbers were entered");
        }else{

        if (number < 0){
          negativeCount++;
        }

        if (number > 0){
          positiveCount++;
        }

        if (number == 0){
          zeroCount++;
        }
        }

          counter++;
        System.out.println("Enter a number or -1 to quit: ");
        number = input.nextInt();

       } 
        
    
     System.out.printf("The count of positive numbers is %d%nThe count of negative numbers is %d%nThe count of zero numbers is %d%n", positiveCount, negativeCount, zeroCount);

     }


 }