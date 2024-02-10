import java.util.Scanner;
  public class Multiplication{

   public static void main(String... args){
    
    Scanner scanner = new Scanner(System.in);
 
    int count = 0;
    int multiple = 0;
 
     System.out.println("Enter a number between 1 and 10: "); 
     int number = scanner.nextInt();

    while(count<12){
      if (number <= 10 && number >0){
     count++;
     multiple = number * count;
      

     System.out.printf("%d x %d = %d%n", number, count, multiple);
     }
   
    

       }
     
       
  }

   }
