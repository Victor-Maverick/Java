import java.util.Scanner;
  public class BarChart{

    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    
    
    System.out.println("Enter a number between 1 and 30");
    int number1 = scanner.nextInt();
    int number2 = scanner.nextInt();
    int number3 = scanner.nextInt();
    int number4 = scanner.nextInt();
    int number5 = scanner.nextInt();
     
    for (int j = 1; j<=number1; j++){
    System.out.print("*");
     }
    System.out.println();
    for (int k = 1; k <= number2; k++){
    System.out.print("*");
     }
    System.out.println();
    for (int i = 1; i<=number3; i++){
    System.out.print("*");
     }
    System.out.println();
    for (int l = 1; l <= number4; l++){
    System.out.print("*");
     }
    System.out.println();
    for (int m = 1; m <= number5; m++){
    System.out.print("*");
     }



       
        
     
      
     
    }


  }