import java.util.Scanner;
 public class TaxCalculator{

 public static void main(String... args){

 Scanner input = new Scanner(System.in);
 
int counter = 0;

 while (counter < 3){
 System.out.println("Enter your name");
 String name = input.next();

 System.out.println("Enter your earining: ");
 double earning = input.nextDouble();
 
 
   if (earning == 30000.0){
	 double taxRate = 0.15 * earning;
	 System.out.printf("%s's total tax rate is %f%n", name, taxRate);
	}
   else if (earning > 30000.0){
	 double taxRate = 0.20 * earning;
	 System.out.printf("%s's total tax rate is %f%n", name, taxRate);
	}
   else if (earning < 30000){
	  System.out.println();
        }
	 counter = counter + 1;
	}
 




 }




 }