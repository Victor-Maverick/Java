import java.util.Scanner;
public class Exchange{

public static void main(String[] args){

Scanner input = new Scanner(System.in);


System.out.println("Enter exchange rate from dollars to RMB");
double exchangeRate = input.nextDouble();

System.out.println("Enter 0 to convert dollars to RMB and 1 vice versa");
double convert = input.nextDouble();

if (convert==0){

System.out.println("Enter the dollar amount");
double dollarAmount = input.nextDouble();
double newYuan = dollarAmount * exchangeRate;

System.out.printf("$%.1f is %.1f yuan", dollarAmount, newYuan);
}

if (convert==1){
System.out.println("Enter the RMB amount");
double yuanAmount = input.nextDouble();
double newDollar = yuanAmount / exchangeRate;

System.out.printf("%.1fRMB is $%.2f", yuanAmount, newDollar);
}
  



}

}