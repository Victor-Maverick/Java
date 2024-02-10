import java.util.Scanner;
public class Money{

public static void main(String[] args){

Scanner input = new Scanner(System.in);

System.out.println("Enter exchange rate from dollars to RMB");
double firstDollar = input.nextDouble();

System.out.println("Enter 0 to convert dollars to RMD and 1 vice versa");
double decision = input.nextDouble();


if (decision==0){

System.out.println("Enter the dollar amount");
double dollAmount = input.nextDouble();

double newYuan = dollAmount * firstDollar;

System.out.printf("$%.1f is %.1f yuan", dollAmount, newYuan);
}

if (decision==1){

System.out.println("Enter the RMB amount");
double yuanAmount = input.nextDouble();

double newDollar = yuanAmount / firstDollar;

System.out.printf("%.1fRMD is $%.2f", yuanAmount, newDollar);
}
  



}

}