import java.util.Scanner;

public class AverageAcceleration{

public static void main(String[] args){

Scanner input = new Scanner(System.in);

System.out.println("Enter starting velocity: ");
double x = input.nextDouble();

System.out.println("Enter ending velocity: ");
Double y = input.nextDouble();

System.out.println("Enter the time taken: ");
double t = input.nextDouble();

double z = (y-x)/t;


System.out.println("The average acceleration is " +z);
}




}