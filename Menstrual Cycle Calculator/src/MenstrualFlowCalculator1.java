import java.time.LocalDate;
import java.util.Scanner;
public class MenstrualFlowCalculator1 {
  private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        MenstrualFlowCalculator flowCalculator = new MenstrualFlowCalculator();

        System.out.println("Welcome to Your Period Tracker");

            flowCalculator.collectAgeRange();
            System.out.println("What is the year of your last flow(e.g 2024): ");
            String year = scanner.nextLine();
            int convertedYear = Integer.parseInt(year);

            while (!(convertedYear >= 2023) || !(convertedYear <= 2025)) {

                System.out.println("Please enter a recent and valid year: ");
                year = scanner.nextLine();
                convertedYear = Integer.parseInt(year);

            }
            System.out.println("Please enter from (01 for units) - 12 for the month");
            String month = flowCalculator.displayMonths();
            int convertedMonth = Integer.parseInt(month);
            while ((month.length() != 2) || convertedMonth < 1 || convertedMonth > 12) {

                month = flowCalculator.displayMonths();
                convertedMonth = Integer.parseInt(month);

            }

            System.out.println("input the first day your last flow started(e.g 01 - 31): ");
            String day = scanner.next();
            int convertedDay = Integer.parseInt(day);
            while ((day.length() != 2) || convertedDay < 1 || convertedDay > 31) {

                System.out.println("Please enter a valid day from (01 for units) - 31 for the day of the month");
                day = scanner.next();


                convertedDay = Integer.parseInt(day);

            }

            int rangeOfFlow = flowCalculator.collectRangeOfFlow();
            while (rangeOfFlow < 1 || rangeOfFlow > 8) {

                rangeOfFlow = flowCalculator.collectRangeOfFlow();

            }
            int lengthOfCycle = flowCalculator.setCycleLength();
            while (lengthOfCycle < 0) {

                lengthOfCycle = flowCalculator.setCycleLength();

            }
            if (lengthOfCycle < 20 || lengthOfCycle > 35) {

                System.out.println("Do you have any health conditions? ");
                String answer = scanner.next();

                while (!answer.equalsIgnoreCase("yes") || !answer.equalsIgnoreCase("no")) {

                    System.out.println("please type yes or no for an answer: ");
                    answer = scanner.next();
                }
                System.out.println("You need to visit a doctor");
            }

            LocalDate startDate = flowCalculator.getPreviousFlowDate(year, month, day);
            System.out.printf("============================================================%nYour next flow will start: ");
            System.out.println(flowCalculator.getNextFlowDate(lengthOfCycle));

            System.out.printf("============================================================%nYour Ovulation is/was on: ");
            System.out.println(flowCalculator.getOvulationDate(startDate));

            System.out.printf("============================================================%nYour Fertile window is between: ");
            System.out.println(flowCalculator.displayFertileWindow(startDate));

            System.out.printf("============================================================%nSafe periods: ");
            System.out.println(flowCalculator.displaySafePeriod(startDate, rangeOfFlow, lengthOfCycle));
            System.out.println("============================================================");
        }

}
