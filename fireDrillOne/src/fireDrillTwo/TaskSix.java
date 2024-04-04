package fireDrillTwo;

import java.util.Scanner;

public class TaskSix {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int sum = 0;
        for (int count = 1; count <= 10; count++) {
            System.out.printf("Enter integer %d: ", count);
            int numberCollected = input.nextInt();

            if (numberCollected % 2 == 0) {
                sum += numberCollected;
            }
        }
        System.out.printf("The average of all values entered is: %.2f", (sum / 10.0));

    }
}
