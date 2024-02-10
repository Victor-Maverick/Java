import java.util.Scanner;
public class Exchange{

public static void main(String[] args){

Scanner input = new Scanner(System.in);


double newYuan = dollarAmount * firstDollar;
double newDollar = dollarAmount / firstDollar;


if (convert==0){
System.out.println("Enter exchange rate from dollars to RMD");
double firstDollar = input.nextDouble();

System.out.println("Enter 0 to convert dollars to RMD and 1 vice versa");
int convert = input.nextDouble();

System.out.println("Enter the dollar amount");
int dollarAmount = input.nextDouble();

System.out.printf("$%f is %f yuan", dollarAmount, newYuan);
}

if (convert==1){
System.out.println("Enter exchange rate from dollars to RMD");
double firstDollar = input.nextDouble();

System.out.println("Enter 0 to convert dollars to RMD and 1 vice versa");
int convert = input.nextDouble();

System.out.println("Enter the RMD amount");
int yuanAmount = input.nextDouble();

System.out.printf("%fRMD is $%f", yuanAmount, dollarAmount);
}
  



}

}