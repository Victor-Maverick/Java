import java.util.Scanner;
public class CarTest{

public static void main(String... args){

Car Car1 = new Car ("Lexus", "2023", 2300000);
Car Car2 = new Car ("Mcclaren", "2024", 2000000);



System.out.printf("%s, %s, price: $%.2f%n", Car1.getModel(), Car1.getYear(), Car1.getPrice());
double priceAmount = 2300000.00-((5.00/100.00)*2300000.00);
System.out.printf("The discounted price is $%.0f%n", priceAmount);


System.out.printf("%s, %s, price: $%.2f%n", Car2.getModel(), Car2.getYear(), Car2.getPrice());

priceAmount = 2000000.00-140000.00;
System.out.printf("The discounted price is $%.0f", priceAmount); 


}





}