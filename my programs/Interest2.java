import java.util.Scanner;

public class Interest2{

	public static void main(String[] args){

	Scanner input= new Scanner(System.in);
	
	System.out.print("Enter Your Balance ");
	
	int b= input.nextInt();
	
	System.out.print("Enter Your Annual Percentage Interest Rate ");

	float i=input.nextFloat();

	float x= i / 1200;
	
	float result = b * x;

	System.out.println("The Interest Is " + result );

}


}