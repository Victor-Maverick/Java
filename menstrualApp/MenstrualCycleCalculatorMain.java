package menstrualApp;

import java.util.Scanner;

public class MenstrualCycleCalculatorMain {
    private static final MenstrualFlowCalculator menstrualFlowCalculator = new MenstrualFlowCalculator();
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        String date = input("Enter the date of your last flow (dd/MM/yyyy): ");
        String cycleLength = input("Enter the average length of your cycle: ");
        String flowRange = input("How many days does it take for your flow to stop: ");
        try {
            print("Your next flow is on "+menstrualFlowCalculator.getNextFlowDate(date, Integer.parseInt(cycleLength), Integer.parseInt(flowRange)));
            print("Your next ovulation is on "+ menstrualFlowCalculator.getOvulationDate());
            print("Your fertile window is from "+menstrualFlowCalculator.displayFertileWindow());
            print("Your safe period is "+menstrualFlowCalculator.displaySafePeriod());
        }
        catch (Exception e){
            print(e.getMessage());
        }
    }

    private static String input(String menu) {
        print(menu);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private static void print(String menu) {
        System.out.println(menu);
    }


}
