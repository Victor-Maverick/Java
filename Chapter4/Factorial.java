import java.util.Scanner;
  public class Factorial{
   public static void main(String[] args){
   Scanner input = new Scanner(System.in);
    System.out.println("Enter a nonnegative integer: ");
    int number = input.nextInt();
    

    int total = 1;
    int count = 1;
 
    while (count <= number){
      total = count * total;
      count++;

    }

    System.out.println(total);

   }




  }