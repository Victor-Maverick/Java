import java.util.Scanner;

  public class GasMileage{

  public static void main(String... args){

  Scanner input = new Scanner(System.in);
  
 
  double totalmilesPerGallon = 0;
  int mileCounter = 0;
  
  System.out.print("Enter the miles driven for the trip or -1 to quit: ");
  int milesDriven = input.nextInt();

  while(milesDriven != -1){
    System.out.print("Enter the gallons used for this trip");
    int gallons = input.nextInt();
    int milesPerGallon = milesDriven / gallons;
    totalMilesPerGallon = totalMilesPerGallon + milesPerGallon;
    mileCounter = mileCounter + 1;
    System.out.print("The miles per gallon for this trip is "+ milesPergallon);
    }

  if (mileCounter != 0){
    double combinedMilesPerGallon = totalMilesPerGallon / mileCounter;
    System.out.print("The combined miles per gallon obtained "+ combinedMilesPerGallon);
  }
    


  }

  


}