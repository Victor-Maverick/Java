import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MenstrualFlowCalculatorTest {


    @Test
    public void testThatMenstrualFlowCalculatorExist(){

        MenstrualFlowCalculator menstrualFlowCalculator = new MenstrualFlowCalculator();
        assertNotNull(menstrualFlowCalculator);
    }

    @Test
    public void testForGettingFirstFlowDate(){

        MenstrualFlowCalculator menstrualFlowCalculator = new MenstrualFlowCalculator();

        assertEquals("2024-12-12", menstrualFlowCalculator.fetchDate("2024", "12", "12"));
    }

    @Test
    public void testForGettingNextFlowDate(){

        MenstrualFlowCalculator menstrualFlowCalculator = new MenstrualFlowCalculator();
        LocalDate date = menstrualFlowCalculator.getPreviousFlowDate("2024", "01", "03");
        LocalDate date1 = menstrualFlowCalculator.getNextFlowDate(26);
        assertEquals(LocalDate.of(2024, 1, 29), date1);
    }

    @Test
    public void testForGettingNextOvulation(){
        MenstrualFlowCalculator menstrualFlowCalculator = new MenstrualFlowCalculator();
        LocalDate ovulationDate = menstrualFlowCalculator.getOvulationDate(LocalDate.of(2024, 1, 3));
        assertEquals(LocalDate.of(2024, 1, 16), ovulationDate);
    }
    @Test
    public void testForTheFertileWindow(){

        MenstrualFlowCalculator menstrualFlowCalculator = new MenstrualFlowCalculator();
        assertEquals("2024-01-12 - 2024-01-18", menstrualFlowCalculator.displayFertileWindow(LocalDate.of(2024, 1, 3)));

    }

    @Test
    public void testForTheSafePeriod(){

        MenstrualFlowCalculator menstrualFlowCalculator = new MenstrualFlowCalculator();
        assertEquals("2024-01-07 - 2024-01-11 and 2024-01-19 - 2024-01-30", menstrualFlowCalculator.displaySafePeriod(LocalDate.of(2024, 1, 3), 4, 27));

    }

}