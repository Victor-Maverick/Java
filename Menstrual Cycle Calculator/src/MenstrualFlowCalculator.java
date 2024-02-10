import java.util.Scanner;
import java.time.LocalDate;
public class MenstrualFlowCalculator {
  private static final Scanner scanner = new Scanner(System.in);
  private LocalDate previousFlowDate;
  private int cycleLength;

    public String fetchDate(String year, String month, String day){

        return year + "-" + month + "-" + day;

    }

    public int setCycleLength(){

        System.out.println("Enter the number of days it takes for your next period to start after one: ");
        cycleLength = scanner.nextInt();

        while(!(cycleLength >= 21) || !(cycleLength <= 35)){

            System.out.println("Normal range is from 21 - 35 daysEnter the number of days it takes for your next period to start after one: ");
            cycleLength = scanner.nextInt();


        }
        return cycleLength;
    }

    public LocalDate getPreviousFlowDate(String year, String month, String day){

        String lastFlowDate = fetchDate(year, month, day);
        this.previousFlowDate = LocalDate.parse(lastFlowDate);

        return previousFlowDate;
    }

    public LocalDate getNextFlowDate(int cycleLength){

        return previousFlowDate.plusDays(cycleLength);
    }

    public LocalDate getOvulationDate(LocalDate previousFlowDate){

        return previousFlowDate.plusDays(13);

    }

    public String displayFertileWindow(LocalDate previousFlowDate){

        String range = "";
        LocalDate startOfFertileWindow = previousFlowDate.plusDays(9);
        LocalDate endOfFertileWindow = previousFlowDate.plusDays(15);

        return range + startOfFertileWindow + " - " + endOfFertileWindow;
    }

    public String displaySafePeriod(LocalDate previousFlowDate, int flowRange, int cycleLength){

        String range = "";
        LocalDate firstRangeValue1 = previousFlowDate.plusDays(flowRange);
        LocalDate firstRangeValue2 = previousFlowDate.plusDays(8);
        LocalDate secondRangeValue1 = previousFlowDate.plusDays(16);
        LocalDate secondRangeValue2 = previousFlowDate.plusDays(cycleLength);

        return range + firstRangeValue1 + " - " + firstRangeValue2 +" and " + secondRangeValue1 + " - " + secondRangeValue2;

    }
    public  String displayMonths(){

        System.out.println("""
        Select the Month of your last flow(01-12):
        01. JANUARY
        02. FEBRUARY
        03. MARCH
        04. APRIL
        05. MAY
        06. JUNE
        07. JULY
        08. AUGUST
        09. SEPTEMBER
        10. OCTOBER
        11. NOVEMBER
        12. DECEMBER
        """);
        String monthInYear = scanner.next();

        return monthInYear;
    }


    public int collectRangeOfFlow(){

        int flowRange;
        System.out.println("How many days does it take for your flow to stop: ");
        flowRange = scanner.nextInt();

        return flowRange;
    }
    public void collectAgeRange(){

        System.out.println("""
    Select your age range
    a. 12 - 18
    b. 19 - 28
    c. 29 - 38
    d. 38 and above""");
        String answer = scanner.next();

    }

}