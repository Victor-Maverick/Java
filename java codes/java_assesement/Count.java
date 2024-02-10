import java.util.Scanner;
public class Count{
public static void main(String[] args){

Scanner scanner = new Scanner(System.in);
System.out.println("Enter a number between one and ten");
int number1 = scanner.nextInt();

while (number1<0 || number1>10){
System.out.println("enter a digit from 1 to 10 only");
number1 = scanner.nextInt();


if(number1==1)
System.out.println("One");

if(number1==2)
System.out.println("Two");

if(number1==3)
System.out.println("Three");

if(number1==4)
System.out.println("four");

if(number1==5)
System.out.println("five");

if(number1==6)
System.out.println("six");

if(number1==7)
System.out.println("Seven");

if(number1==8)
System.out.println("Eight");

if(number1==9)
System.out.println("Nine");

if(number1==10){
System.out.println("Ten");
}


}




}




}