import java.util.Scanner;
public class You{

public static void main(String[] args){

Scanner input = new Scanner(System.in);

System.out.println("Enter an integer between 0 and 1000");
int x = input.nextInt();
int w = x % 10;
int v = x / 10;
int u = v % 10;
int y = v / 10;
int z = y % 10;
int q = y / 10;
int result = (w + u + z);
if (x < 0 ){
System.out.println("Invalid input");
}
if (x > 1000 ){
System.out.println("Invalid input");
}
System.out.println("The sum of the digits is " +result);



}

}