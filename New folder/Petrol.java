import java.util.Scanner;

public class Petrol{

public static void main(String... args){

PetrolPurchase purchase1 = new PetrolPurchase("Yaba MegaStation", "Diesel", 10, 585.50, 5.0);

Scanner scanner = new Scanner(System.in);

System.out.printf("Welcome to %s%n", purchase1.getLocation());

System.out.println("Enter the type you want to buy: ");
String type = scanner.nextLine();
purchase1.setType(type);
purchase1.getType();


System.out.println("Enter the quantity you want to buy in litres");
int quantity = scanner.nextInt();
purchase1.setQuantity(quantity);
purchase1.getQuantity();


System.out.printf("%s %s %d price per litre: $%.2f ", purchase1.getLocation(), purchase1.getType(), purchase1.getQuantity(), purchase1.getPrice());


System.out.printf("Pay %f as your discounted price", purchase1.getPurchaseAmount());


}




}