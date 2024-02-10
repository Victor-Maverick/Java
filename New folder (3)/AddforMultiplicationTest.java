import java.util.Scanner;
public class AddforMultiplicationTest{

  public static void main(String[] args){

    AddforMultiplication multiplyNumbers = new AddforMultiplication();
    Scanner input = new Scanner(System.in);

    System.out.println("Enter two numbers to multiply");
    int number1 = input.nextInt();
    int number2 = input.nextInt();

  System.out.printf("%d x %d will evaluate to %d%n", number1, number2, multiplyNumbers.MultiplicatinValue(number1, number2));

  }

}