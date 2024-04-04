package fireDrillTwo;
import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int sum = 0;
        for (int count = 0; count < 10; count++){
            System.out.println("Enter an integer: ");
            int numberCollected = input.nextInt();
            sum += numberCollected;
        }
        double average = sum / 10.0;
        System.out.printf("The average of all values entered is: %.1f", average);
    }
}
