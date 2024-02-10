import java.util.Scanner;
  public class NumberLine{

   public static void main(String... args){

    Scanner scanner = new Scanner(System.in);
 
    System.out.println("Enter a number: "); 
    int number = scanner.nextInt();

     if (number < 0){
      int abs = -1 * number;
      System.out.printf("The absolute value of %d is %d", number, abs);
     }else{
      int abs2 = number;
      System.out.printf("The absolute value of %d is %d", number, abs2);
     
      }
     
   }



  }