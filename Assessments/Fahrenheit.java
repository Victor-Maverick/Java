import java.util.Scanner;
public class Fahrenheit{

public static void main(String[] args){

Scanner input = new Scanner(System.in);
System.out.println("Enter a degree in Celsius");
double temp = input.nextDouble();
double tempInFahrenheit = (9.0/5) * temp + 32;

System.out.printf("%f Celsius is %.1f Fahrenheit", temp, tempInFahrenheit);

}





}