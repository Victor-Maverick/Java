package fireDrillTwo;

import java.util.Scanner;

public class TaskEight {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int sum = 0;
        for (int count = 1; count <= 10; count++) {
            System.out.println("Enter an integer from 1 to 100: ");
            int numberCollected = input.nextInt();

            while(numberCollected < 0 || numberCollected > 100) {
                System.out.println("Enter an integer from 1 to 100 only: ");
                numberCollected = input.nextInt();
            }
            sum += numberCollected;
        }
        System.out.printf("The sum of the values is %d", sum);

    }
}
