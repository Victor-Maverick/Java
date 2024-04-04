import java.util.Scanner;
  public class PopulationCalculator{

  public static void main(String... args){

  Scanner scanner = new Scanner(System.in);
  
  System.out.println("Enter the current world population ");
  double worldPopulation = scanner.nextDouble();

  System.out.println("Enter the annual world population growth rate: ");
  double growthRate = scanner.nextDouble();

  double populationAfterOneYear = worldPopulation + ((growthRate / 100) * worldPopulation);
  double populationAfterTwoYears = populationAfterOneYear + ((growthRate / 100) * populationAfterOneYear);

  double populationAfterThreeYears = populationAfterTwoYears + ((growthRate / 100) * populationAfterTwoYears);

  double populationAfterFourYears = populationAfterThreeYears + ((growthRate / 100) * populationAfterThreeYears);

  double populationAfterFiveYears = populationAfterFourYears + ((growthRate / 100) * populationAfterFourYears);

  

  

  System.out.printf("The population after 1 year will be: %.0f%n", populationAfterOneYear);

  System.out.printf("The population after 2 years will be: %.0f%n", populationAfterTwoYears);
  
  System.out.printf("The population after 3 years will be: %.0f%n", populationAfterThreeYears);

  System.out.printf("The population after 4 years will be: %.0f%n", populationAfterFourYears);

  System.out.printf("The population after 5 years will be: %.0f%n", populationAfterFiveYears);





  }



}