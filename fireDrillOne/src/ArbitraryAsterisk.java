import java.util.ArrayList;
import java.util.Scanner;
public class ArbitraryAsterisk {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter a number between 1 and 15 only(enter 22 to quit): ");
        int numberCollected = scanner.nextInt();

        while(numberCollected != 22){

            while(numberCollected < 1 || numberCollected > 15) {
                System.out.println("Enter a number between 1 and 15(enter 22 to quit): ");
                numberCollected = scanner.nextInt();

            }
            numbers.add(numberCollected);
            System.out.println("Enter a number between 1 and 15(enter 22 to quit): ");
            numberCollected = scanner.nextInt();
        }


        for (int index = 0; index < numbers.size(); index++) {
            for (int count = 0; count < numbers.get(index); count++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
