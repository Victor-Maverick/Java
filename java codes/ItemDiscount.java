import java.util.Scanner;
  public class ItemDiscount{

   public static void main(String... args){
    String discount = "10%";
    Scanner scanner = new Scanner(System.in);
 
    System.out.println("Enter an item: "); 
    String itemName = scanner.next();

    System.out.println("Enter the price for the item");
    double price = scanner.nextDouble();

    
    if (price < 0.0){
     System.out.printf("Item: %s%nPrice: %.2f%nDiscount: %s%n---------------------------------------------------%nGrand total: You owe %.2f%nPay due amount%n---------------------------------------------------", itemName, price, discount, price);
    }
    else if(price > 0.0){
      double total = 0.1 * price;
      double grandTotal = price - total;
      System.out.println();
      System.out.printf("Item: %s%nPrice: %.2f%nDiscount: %s%n---------------------------------------------------%nGrand total: %.2f%n---------------------------------------------------", itemName, price, discount, grandTotal);
    }else{
     System.out.printf("Item: %s%nPrice: %.2f%nDiscount: %s%n---------------------------------------------------%nGrand total: %.2f%nPrice is null%n---------------------------------------------------", itemName, price, discount, price);

    
   }
  }
 

}