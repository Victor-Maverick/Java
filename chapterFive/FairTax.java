import java.util.Scanner;
public class FairTax{

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    System.out.println("Enter the expenses in the cateogories: \nHousing = ");
    double houseExpense = input.nextDouble();

    System.out.println("Food = ");
    double foodExpense = input.nextDouble();

    System.out.println("Clothing = ");
    double clothingExpense = input.nextDouble();

    System.out.println("Transportation = ");
    double transportExpense = input.nextDouble();

    System.out.println("Education = ");
    double educationExpense = input.nextDouble();

    System.out.println("Health care = ");
    double healthExpense = input.nextDouble();

    System.out.println("Vacations = ");
    double vacationExpense = input.nextDouble();

    double total = 0;
    double tax = 23;
    double fairTax = 0;
    total = houseExpense + foodExpense + clothingExpense + transportExpense + educationExpense + healthExpense + vacationExpense;

    fairTax = total * (tax * 0.01);

    System.out.printf("The estimated FairTax you are to pay is %.2f", fairTax);
  }


}