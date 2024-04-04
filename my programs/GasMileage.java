import java.util.Scanner;
  public class GasMileage{

  public static void main(String... args){
  
  Scanner scanner = new Scanner(System.in);
 
  double totalMilesPerGallon = 0;
  int halt = 0;
  int totalGallonsUsed = 0;
  int totalMilesDriven=0;
  

  while (halt != -1){
    System.out.print("Enter the miles driven for this trip: ");
    int miles = scanner.nextInt();

    System.out.print("enter the gallons used per tankfull");
    int gallons = scanner.nextInt();
    System.out.println();

	totalMilesPerGallon += milesPerGallon;

	System.out.printf("Miles per gallon for this trip is %.1f%n",   milesPerGallon );
    
        System.out.println();

    	System.out.print("Enter -1 to stop or 2 to continue: ");	halt = scanner.nextInt();
  }
  
 System.out.print("Total miles per gallon is : " + totalMilesPerGallon);
  }

}