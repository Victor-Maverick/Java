import java.util.Scanner;
  public class SalesCommission{

  public static void main(String... args){
  
  Scanner input = new Scanner(System.in);

  int salesCounter = 0;
  double valueTotal = 0;
  


System.out.println("Enter the value of the item sold: "); 
    double value = input.nextDouble();

  while (value != -2){
    

    valueTotal += value;
    salesCounter++;
 value = input.nextDouble();
    

    }
  
  if (valueTotal != 0){
    double payPerWeek = 0.9 * valueTotal + 200;
    System.out.printf("This salesperson's pay per week is $%.1f", payPerWeek);
  }


   

 
  




  }






  }