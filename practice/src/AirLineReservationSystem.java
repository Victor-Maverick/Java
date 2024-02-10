import java.util.Arrays;
import java.util.Scanner;
import java.security.SecureRandom;
public class AirLineReservationSystem {

    private Booker booker;

    private static SecureRandom randomNumber = new SecureRandom();
    private static Scanner input = new Scanner(System.in);
    private static boolean[] seatNumber;

    public  AirLineReservationSystem() {

        seatNumber = new boolean[10];
        for (int count = 0; count < seatNumber.length; count++) {

            seatNumber[count] = false;

        }

    }

    public static boolean[] assignDefaultSeatNumber() {

        seatNumber = new boolean[10];
        Arrays.fill(seatNumber, false);
        return seatNumber;

    }

    public static int displayOptions(){
        System.out.println("Choose 1 or 2 to select\n1 First class\n2 Economy");
        int choice = input.nextInt();

        return choice;
    }
    public static void assignSeatNumber(int playerId) {

        boolean[] seats = assignDefaultSeatNumber();
        int decision = displayOptions();
        int number = 0;
        if (decision == 1) {

            for (int count = 0; count < seats.length / 2; count++) {

                number = 0 + randomNumber.nextInt(4);
                if (seats[number] == false) {
                    seats[number] = true;
                    System.out.println(number);
                }
                /*if(seats[number] == true) {
                    number = 0 + randomNumber.nextInt(4);
                    if (seats[number] != true)
                        seats[number] = true;
                }*/
                System.out.println(seats[number]);
            }

        } else if (decision == 2) {

            for (int count = 4; count < seats.length; count++) {

                number = 4 + randomNumber.nextInt(9);
                if (seats[number] == false) {
                    seats[number] = true;
                }
                while (seats[number] == true) {
                    number = 0 + randomNumber.nextInt(4);
                    if (seats[number] != true)
                        seats[number] = true;
                }
                System.out.println(seats[number]);
            }

        }

    }

    public static void main(String[] args){
        assignSeatNumber();

    }

}