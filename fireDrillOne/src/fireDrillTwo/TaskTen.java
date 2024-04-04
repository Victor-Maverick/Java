package fireDrillTwo;

import java.util.Scanner;

public class TaskTen {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int sum = 0;
        int counter = 0;
        for (int count = 1; count <= 10; count++) {
            System.out.println("Enter an integer from 1 to 100: ");
            int numberCollected = input.nextInt();

            if (numberCollected > 0 && numberCollected <= 100) {
                sum += numberCollected;
                counter++;
            }
        }
        System.out.printf("The  of the values is %.2f", ((double)sum / counter));

    }
}
