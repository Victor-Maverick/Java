import java.util.Scanner;
public class Giza{

	public static void main(String[] args){

	Scanner input = new Scanner(System.in);

	System.out.println("Enter the estimated number of stones used ");
	int numberOfStones = input.nextInt();

	System.out.println("Enter the number of years taken to build the pyramid ");
	int numberOfYears = input.nextInt();

	System.out.println("Enter the average weight of each stone used ");
	float weightOfEachStoneUsed = input.nextFloat();


	float totalWeightOfBlock = numberOfStones * weightOfEachStoneUsed;
	float weightOfPyramidPerYear = totalWeightOfBlock / numberOfYears;
	float weightOfPyramidPerDay = weightOfPyramidPerYear / 365;
	float weightOfPyramidPerHour = weightOfPyramidPerDay / 24;
	double weightOfPyramidPerMinute = weightOfPyramidPerHour / 60;
	
	System.out.printf("The weight of the pyramid built each year was %f%n", weightOfPyramidPerYear);

	System.out.printf("The weight of the pyramid built each hour was %f%n", weightOfPyramidPerHour);
	
	System.out.printf("The weight of the pyramid built each minute was %f%n", weightOfPyramidPerMinute);


}





}