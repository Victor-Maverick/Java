package menstrualApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MenstrualFlowCalculator {
        private LocalDate previousFlowDate;
        private int cycleLength;
        private int flowRange;
        private int daysToOvulation;
        public String getNextFlowDate(String date, int lengthOFCycle, int rangeOfFlow){
            parseInputToDate(date);
            cycleLength = lengthOFCycle;
            flowRange = rangeOfFlow;
            validateCycleLength();
            return "" +previousFlowDate.plusDays(cycleLength);
        }

    private void validateCycleLength() {
        if(cycleLength < 18 || cycleLength > 35)throw new IllegalArgumentException("You need to see a doctor");
        if(cycleLength > 18 && cycleLength < 25)daysToOvulation = 11;
        else if(cycleLength > 24 && cycleLength < 29)daysToOvulation = 13;
        else if(cycleLength > 28 && cycleLength < 31)daysToOvulation = 16;
        else if(cycleLength > 30)daysToOvulation = 20;
    }

    private void parseInputToDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        previousFlowDate = LocalDate.parse(date, dateTimeFormatter);
        if(!previousFlowDate.isSupported(ChronoUnit.MILLENNIA))throw new IllegalArgumentException("wrong input with date");
    }

        public LocalDate getOvulationDate(){
            return previousFlowDate.plusDays(daysToOvulation);
        }

        public String displayFertileWindow(){
            LocalDate ovulation = getOvulationDate();
            LocalDate startOfFertileWindow = ovulation.minusDays(5);
            LocalDate endOfFertileWindow = ovulation.plusDays(1);

            return startOfFertileWindow + " - " + endOfFertileWindow;
        }

        public String displaySafePeriod(){
            LocalDate ovulation = getOvulationDate();
            LocalDate firstRangeValue1 = previousFlowDate.plusDays(flowRange);
            LocalDate firstRangeValue2 = ovulation.minusDays(6);
            LocalDate secondRangeValue1 = ovulation.plusDays(daysToOvulation);
            LocalDate secondRangeValue2 = previousFlowDate.plusDays(cycleLength);

            return  firstRangeValue1 + " - " + firstRangeValue2 +" and " + secondRangeValue1 + " - " + secondRangeValue2;

        }

}
