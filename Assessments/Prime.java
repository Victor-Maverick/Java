import java.util.Scanner;
  public class Prime{

    public static void main(String[] args){
     
     Scanner input = new Scanner(System.in);
     
     System.out.println("Enter a positive number: ");
     int number = input.nextInt();

     int count = 0;
     int count2 = 0;

     for (int i = 1; i <= number; i++){
        count2 = number/i;
         if (number % i == 0){
           count++;
         }
      }

      if (count == 2){
           System.out.printf("%d is a prime number", number);
         }
           else {
              System.out.printf("%d is not a prime number", number);
           }
        
    



    }



  }