import java.util.Scanner;

public class Triangle{
public static void main(String... args){

Scanner input = new Scanner(System.in);

System.out.println("Enter the first edge: ");
int edgeOne = input.nextInt();

System.out.println("Enter the second edge value of the triangle");
int edgeTwo = input.nextInt();

System.out.println("Enter the third edge value of the triangle");
int edgeThree = input.nextInt();

int firstSum = edgeOne + edgeTwo;
int secondSum = edgeTwo + edgeThree;
int thirdSum = edgeOne + edgeThree;
int perimeter = edgeOne + edgeTwo + edgeThree;

if (firstSum > edgeThree && secondSum > edgeOne && thirdSum > edgeTwo){
  System.out.printf("the perimeter of the triangle is: %d", perimeter);
	}else{
		System.out.println("INVALID INPUT");
	}

}




}