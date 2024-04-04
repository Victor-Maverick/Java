import java.util.Scanner;
public class BodyIndex{

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter weight in pounds ");
		float weightInPounds = scanner.nextFloat();
		
		System.out.println("Enter height in inches ");
		float heightInInches = scanner.nextFloat();
		
		double weightInKilograms = weightInPounds*0.454;
		double productOfHeights = heightInInches*0.0254;
		double squaredProductOfHeights = productOfHeights*productOfHeights;
		
		double BodyMassIndex = weightInKilograms / squaredProductOfHeights;

		System.out.printf("The Body Mass Index is %f%n ", BodyMassIndex);
	}





}