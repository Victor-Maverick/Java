package fireDrillTwo;
import java.util.Scanner;
public class TaskOne {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int sum = 0;
        for (int count = 0; count < 10; count++){
            System.out.println("Enter an integer: ");
            int numberCollected = input.nextInt();
            sum += numberCollected;
        }
        System.out.printf("The sum of all values entered are: %d", sum);
    }
}
