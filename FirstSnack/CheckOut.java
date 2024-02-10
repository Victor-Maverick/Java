import java.util.Scanner;
import java.util.ArrayList;

public class CheckOut{
  public static void main(String[] args){
  Scanner scanner = new Scanner(System.in);

 ArrayList<String> items = new ArrayList<String>();
 ArrayList<Integer> number = new ArrayList<Integer>();
 ArrayList<Double> prices = new ArrayList<Double>();
 
  System.out.println("What is the customers name? ");
  String name = scanner.nextLine();

  System.out.println("What did the user buy? ");
  String item = scanner.next();
  items.add(item);

  System.out.println("How many pieces? ");
  int quantity = scanner.nextInt();
  number.add(quantity);

  System.out.println("How much per unit? ");
  double price = scanner.nextInt();
  prices.add(price);  

  System.out.println("Add more items? ");
  String answer = scanner.next();

  while(answer.equalsIgnoreCase("yes")){
  System.out.println("What did the user buy? ");
  item = scanner.next();
  items.add(item);

  System.out.println("How many pieces? ");
  quantity = scanner.nextInt();
  number.add(quantity);

  System.out.println("How much per unit? ");
  price = scanner.nextInt();
  prices.add(price);

  System.out.println("Add more items? ");
  answer = scanner.next();
  }

  System.out.println("What is your name? ");
  String cashierName = scanner.next();

  System.out.println("How much discount will the customer get? ");
  int discount = scanner.nextInt();
 
  System.out.printf("%n%n");

  System.out.printf("%s%n%s%n%s%n%s%n%s%nCashier's Name: %s%nCustomer's Name: %s%n%s%n	  %s	%s	%s		%s%n", "SEMICOLON STORES", "MAIN BRANCH", "LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS", "TEL: 08146785467", "Date: 22-Dec-23 8:43:12 pm", cashierName, name, "==================================================", "ITEM", "QTY", "PRICE", "TOTAL(NGN)");


 int index = 0;
 int counter = 0;
 for(int count = 0; count < items.size(); count++){
  System.out.printf("	%s	%d	%.2f		%.2f%n", items.get(count), number.get(index), prices.get(counter), (number.get(index) * prices.get(counter)));
 index++;
 counter++;
 }
  System.out.println("-----------------------------------------------");

  int i = 0;
  int j = 0;
  double total = 0;
  for(int k =0; k<items.size(); k++){
    double product = number.get(i) * prices.get(j);
    total+=product;
    i++;
    j++;
  }
  double discountRate = (discount * 0.01) * total;
  double vat = 0.175 * total; 
  System.out.printf("%n%n");
  System.out.printf("		  Sub Total:	%.2f%n		   discount:	%.2f%n		VAT @ 17.50:	%.2f%n", total, discountRate, vat);

  System.out.printf("%s%n", "==================================================");

double billTotal = total - discountRate + vat;

System.out.printf("		Bill Total:	%.2f%n", billTotal);

System.out.printf("%s%n THIS IS NOT AN RECEIPT KINDLY PAY %.2f%n", "==================================================", billTotal);

System.out.printf("%s%n", "==================================================");

System.out.println("How much did the customer give to you? ");
double amountPaid = scanner.nextDouble();
double balance = 0;
  if (amountPaid > billTotal){
  balance = amountPaid - billTotal;
  }
  else if(amountPaid == billTotal){
  balance = 0.00; 
  }
  else{
  System.out.println("Pay appropriate amount");
  }

  System.out.println("\n\n");

  System.out.printf("%s%n%s%n%s%n%s%n%s%nCashier's Name: %s%nCustomer's Name: %s%n%s%n	  %s	%s	%s		%s%n", "SEMICOLON STORES", "MAIN BRANCH", "LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS", "TEL: 08146785467", "Date: 22-Dec-23 8:44:02 pm", cashierName, name, "==================================================", "ITEM", "QTY", "PRICE", "TOTAL(NGN)");
 int index2 = 0;
 int counter2 = 0;
 for(int count1 = 0; count1 < items.size(); count1++){
  System.out.printf("	%s	%d	%.2f		%.2f%n", items.get(count1), number.get(index2), prices.get(counter2), (number.get(index2) * prices.get(counter2)));
 index2++;
 counter2++;
 }
  System.out.println("-------------------------------------------------");

  System.out.printf("%n%n");
  System.out.printf("		  Sub Total:	%.2f%n		   discount:	%.2f%n		VAT @ 17.50:	%.2f%n", total, discountRate, vat);

  System.out.printf("%s%n", "==================================================");

  System.out.printf("		Bill Total:	%.2f%n		Amount paid:	%.2f%n		   Balance:	%.2f%n", billTotal, amountPaid, balance);

System.out.printf("%s%n	%s%n", "==================================================", "THANKS FOR YOUR PATRONAGE");
b
System.out.printf("%s%n", "==================================================");


}



}