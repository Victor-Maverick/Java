package logisticsTest;

import logisticServices.LogisticsServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogisticsServicesTest {
    private LogisticsServices logisticsServices;

    @BeforeEach
    public void beginEachWith(){
        logisticsServices = new LogisticsServices();
    }

    @Test
    public void calculateRiderEarningOnLessThanFiftyPercentDeliveryTest(){
        assertEquals(9000, logisticsServices.calculateWageForTheDay(25));
    }

    @Test
    public void calculateRiderEarningWithDeliveryBetweenFiftyToFiftyNinePercentTest(){
        assertEquals(15000, logisticsServices.calculateWageForTheDay(50));
    }

    @Test
    public void calculateRiderEarningWithDeliveryBetweenSixtyToSixtyNinePercentTest(){
        assertEquals(20000, logisticsServices.calculateWageForTheDay(60));
    }

    @Test
    public void calculateRiderEarningWithDeliveryGreaterThanSixtyNinePercentTest(){
        assertEquals(40000, logisticsServices.calculateWageForTheDay(70));
    }

    @Test
    public void collectNegativeOrInvalidDeliverySuccesses_throwExceptionTest(){
        assertThrows(IllegalArgumentException.class, ()-> logisticsServices.calculateWageForTheDay(-25));
    }

    @Test
    public void riderWageIsOnlyBaseSalaryIfZeroDeliveryWasMadeTest(){
        assertEquals(5000, logisticsServices.calculateWageForTheDay(0));
    }

}
