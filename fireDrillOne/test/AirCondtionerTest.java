import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirCondtionerTest {
    private AirConditioner airCondtioner;

    @BeforeEach
    public void initializeAc(){
        airCondtioner = new AirConditioner();
    }

    @Test
    public void AcIsTurnedOn_AcIsOn(){
        assertFalse(airCondtioner.isPowerOn());
        airCondtioner.toggle();
        assertTrue(airCondtioner.isPowerOn());
    }

    @Test
    public void AcIsTurnedOff_AcIsOff(){
        assertFalse(airCondtioner.isPowerOn());
        airCondtioner.toggle();
        assertTrue(airCondtioner.isPowerOn());

        airCondtioner.toggle();
        assertFalse(airCondtioner.isPowerOn());
    }

    @Test
    public void increaseTemperature_temperatureIncreases(){
        assertFalse(airCondtioner.isPowerOn());
        airCondtioner.toggle();
        assertTrue(airCondtioner.isPowerOn());
        assertEquals(16, airCondtioner.getTemperature());
        airCondtioner.increaseTemperature();
        assertEquals(17, airCondtioner.getTemperature());

    }

    @Test
    public void decreaseTemperature_temperatureDecreases(){
        assertFalse(airCondtioner.isPowerOn());
        airCondtioner.toggle();
        assertTrue(airCondtioner.isPowerOn());
        assertEquals(16, airCondtioner.getTemperature());
        airCondtioner.increaseTemperature();
        assertEquals(17, airCondtioner.getTemperature());
        airCondtioner.increaseTemperature();
        assertEquals(18, airCondtioner.getTemperature());
        airCondtioner.decreaseTemperature();
        assertEquals(17, airCondtioner.getTemperature());

    }

    @Test
    public void increaseTemperature_temperatureIncreasesToThirtyOnly(){
        assertFalse(airCondtioner.isPowerOn());
        airCondtioner.toggle();
        assertTrue(airCondtioner.isPowerOn());
        assertEquals(16, airCondtioner.getTemperature());

        for(int count = 0; count < 16; count++){
            airCondtioner.increaseTemperature();
        }
        assertEquals(30,  airCondtioner.getTemperature());

    }

    @Test
    public void decreseTemperature_temperaturedecreaseToSixteen(){
        assertFalse(airCondtioner.isPowerOn());
        airCondtioner.toggle();
        assertTrue(airCondtioner.isPowerOn());
        assertEquals(16, airCondtioner.getTemperature());

        for(int count = 0; count < 6; count++){
            airCondtioner.increaseTemperature();
        }
        assertEquals(22,  airCondtioner.getTemperature());
        for(int count = 0; count < 10; count++){
            airCondtioner.decreaseTemperature();
        }
        assertEquals(16, airCondtioner.getTemperature());

    }

}
