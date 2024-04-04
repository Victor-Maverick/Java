import java.util.Scanner;
  public class PositiveNegativeSum{

    public static void main(String... args){

    Scanner scanner = new Scanner(System.in);
   

    int counter = 0;
    int positiveNumbers= 0;
    int negativeNumbers = 0;
    int total = 0;
    double average = 0;

    System.out.println("Enter an integer, the input ends if it is 0:");
    int number = scanner.nextInt();

    while (number != 0){
      if (number <= -1){
        negativeNumbers += 1;
      }
      else if (number >= 1){
        positiveNumbers += 1;
      }

      counter++;
      total += number;

      System.out.println("Enter an integer, the input ends if it is 0:");
      number = scanner.nextInt();
     }

    if (counter != 0){
      average = (double)total / counter;
      System.out.printf("The number of positives is %d%n", positiveNumbers);
      System.out.printf("The number of negatives is %d%n", negativeNumbers);
      System.out.printf("The total is %d%n", total);
      System.out.printf("The average is %.2f%n", average);
    }
    else {
      System.out.printf("No numbers are entered except 0");

    }

    }

  }