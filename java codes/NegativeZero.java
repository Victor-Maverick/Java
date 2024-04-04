import java.util.Scanner;

public class NegativeZero{

	public static void main(String[] args){

	Scanner input = new Scanner(System.in);

	System.out.println("Enter 5 numbers");
	int num1 = input.nextInt();
	int num2 = input.nextInt();	
	int num3 = input.nextInt();
	int num4 = input.nextInt();	
	int num5 = input.nextInt();

	int positiveNumbers=0;
	int negativeNumbers=0;
	int zeroNumbers=0;
	
	if(num1==0){zeroNumbers+=1;}
	if(num2==0){zeroNumbers+=1;}
	if(num3==0){zeroNumbers+=1;}
	if(num4==0){zeroNumbers+=1;}
	if(num5==0){zeroNumbers+=1;}

	if(num1<0){negativeNumbers+=1;}
	if(num2<0){negativeNumbers+=1;}
	if(num3<0){negativeNumbers+=1;}
	if(num4<0){negativeNumbers+=1;}
	if(num5<0){negativeNumbers+=1;}

	if(num1>0){positiveNumbers+=1;}
	if(num2>0){positiveNumbers+=1;}
	if(num3>0){positiveNumbers+=1;}
	if(num4>0){positiveNumbers+=1;}
	if(num5>0){positiveNumbers+=1;}

	System.out.printf("The negative numbers are %d%n The positive numbers are %d%n The zero numbers are %d%n", negativeNumbers, positiveNumbers, zeroNumbers);
	}





}