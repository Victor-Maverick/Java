import java.util.Scanner;
public class Length{

public static void main(String[] args){

Scanner input = new Scanner(System.in);

System.out.println("Enter speed and acceleration: ");
float v = input.nextFloat();
float a = input.nextFloat();

float l = (v * v) / (2 * a);

System.out.println("The minimum runway length for this airplane is " +l);;
 



}






}