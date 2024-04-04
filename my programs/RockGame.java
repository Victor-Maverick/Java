import java.util.Scanner;
public class RockGame{

public static void main(String[] args){
Scanner input = new Scanner(System.in);

System.out.println("Enter player one name");
String name1 = input.nextLine();

System.out.println("Enter player two name");
String name2 = input.nextLine();

System.out.printf("%s enter a number 0,1 or 2%n%n", name1);
int num1 = input.nextInt();
System.out.printf("%s enter a number 0,1 or 2%n%n", name2);
int num2 = input.nextInt();

if (num1==0 && num2==0)  
System.out.println("That's a draw");

if (num1==1 && num2==1)
System.out.println("That's a draw");

if (num1==2 && num2==2)
System.out.println("That's a draw");

if (num1==0 && num2==1)
System.out.printf("%s won %s", name2, name1);

if (num1==0 && num2==2)
System.out.printf("%s won %s", name1, name2);


if (num1==1 && num2==0)
System.out.printf("%s won %s", name1, name2);


if (num1==1 && num2==2)
System.out.printf("%s won %s", name2, name1);


if (num1==2 && num2==0)
System.out.printf("%s won %s", name2, name1);


if (num1==2 && num2==1)
System.out.printf("%s won %s", name1, name2);






}





}