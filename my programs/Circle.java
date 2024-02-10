import java.util.Scanner;

   public class Circle{
   
   public static void main(String... args){

   Scanner input = new Scanner(System.in);

   System.out.println("Enter a radius");
   int radius = input.nextInt();

   double PI = 3.14159;
 
   System.out.printf("The circle has a diameter of %d%n", (2 * radius));

   System.out.printf("The circle has a circumference of %.2f%n", (2 * PI * radius));

   System.out.printf("The circle has an area of %.2f%n", (PI * radius * radius));






  }




}