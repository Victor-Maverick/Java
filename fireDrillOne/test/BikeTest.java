import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {
    private Bike bike;

    @BeforeEach
    public void setup(){
        bike = new Bike();
    }

    @Test
    public void turnOnBike_bikeIsOn(){
        assertFalse(bike.isBikeOn());
        bike.toggle();
        assertTrue(bike.isBikeOn());
    }

    @Test
    public void turnOffBike_bikeIsOff(){
        assertFalse(bike.isBikeOn());
        bike.toggle();
        assertTrue(bike.isBikeOn());
        bike.toggle();
        assertFalse(bike.isBikeOn());
    }

    @Test
    public void accelerateInGearOne_speedIncreaseByOne(){
        assertFalse(bike.isBikeOn());
        bike.toggle();
        assertTrue(bike.isBikeOn());
        assertEquals(0, bike.getGear());

        for(int count = 1; count <= 15; count++){
            bike.accelerate();
        }
        assertEquals(1, bike.getGear());
        assertEquals(15, bike.getSpeed());

        bike.accelerate();
        assertEquals(1, bike.getGear());
        assertEquals(16, bike.getSpeed());

    }

    @Test
    public void accelerateInGearTwo_speedIncreasesByTwo(){
        assertFalse(bike.isBikeOn());
        bike.toggle();
        assertTrue(bike.isBikeOn());
        assertEquals(0, bike.getGear());

        for(int count = 1; count <= 21; count++){
            bike.accelerate();
        }
        assertEquals(21, bike.getSpeed());
        assertEquals(1,  bike.getGear());

        bike.accelerate();
        bike.accelerate();
        assertEquals(25, bike.getSpeed());
        assertEquals(2,  bike.getGear());

        bike.accelerate();
        assertEquals(27, bike.getSpeed());
        assertEquals(2,  bike.getGear());

    }

    @Test
    public void accelerateInGearThree_speedIncreasesByThree(){
        assertFalse(bike.isBikeOn());
        bike.toggle();
        assertTrue(bike.isBikeOn());
        assertEquals(0, bike.getGear());

        for(int count = 1; count <= 21; count++){
            bike.accelerate();
        }
        assertEquals(1, bike.getGear());
        assertEquals(21, bike.getSpeed());

        for (int count = 1; count <= 5; count++){
            bike.accelerate();
        }
        assertEquals(2, bike.getGear());
        assertEquals(31, bike.getSpeed());

        bike.accelerate();
        bike.accelerate();
        assertEquals(3, bike.getGear());
        assertEquals(37, bike.getSpeed());

    }

    @Test
    public void accelerateInGearFour_speedIncreasesByFour(){
        assertFalse(bike.isBikeOn());
        bike.toggle();
        assertTrue(bike.isBikeOn());
        assertEquals(0, bike.getGear());

        for(int count = 1; count <= 21; count++){
            bike.accelerate();
        }
        assertEquals(1, bike.getGear());
        assertEquals(21, bike.getSpeed());

        for (int count = 1; count <= 5; count++){
            bike.accelerate();
        }
        assertEquals(2, bike.getGear());
        assertEquals(31, bike.getSpeed());

        for(int count = 1; count <= 3; count++) {
            bike.accelerate();
        }
        assertEquals(3, bike.getGear());
        assertEquals(40, bike.getSpeed());

        bike.accelerate();
        assertEquals(3, bike.getGear());
        assertEquals(43, bike.getSpeed());

        bike.accelerate();
        assertEquals(4, bike.getGear());
        assertEquals(47, bike.getSpeed());

    }

    @Test
    public void decelerateInGearOne_speedDecreaseByOne(){
        assertFalse(bike.isBikeOn());
        bike.toggle();
        assertTrue(bike.isBikeOn());
        assertEquals(0, bike.getGear());

        for(int count = 1; count <= 15; count++){
            bike.accelerate();
        }
        assertEquals(1, bike.getGear());
        assertEquals(15, bike.getSpeed());
        bike.decelerate();
        assertEquals(14, bike.getSpeed());

    }

    @Test
    public void decelerateInGearTwo_speedDecreasesByTwo(){
        assertFalse(bike.isBikeOn());
        bike.toggle();
        assertTrue(bike.isBikeOn());
        assertEquals(0, bike.getGear());

        for(int count = 1; count <= 21; count++){
            bike.accelerate();
        }
        assertEquals(1, bike.getGear());
        assertEquals(21, bike.getSpeed());

        bike.accelerate();
        bike.accelerate();
        assertEquals(2, bike.getGear());
        assertEquals(25, bike.getSpeed());

        bike.decelerate();
        assertEquals(23, bike.getSpeed());

    }

    @Test
    public void decelerateInGearThree_speedDecreasesByThree(){
        assertFalse(bike.isBikeOn());
        bike.toggle();
        assertTrue(bike.isBikeOn());
        assertEquals(0, bike.getGear());
        for(int count = 1; count <= 21; count++){
            bike.accelerate();
        }
        assertEquals(1, bike.getGear());
        assertEquals(21, bike.getSpeed());
        for (int count = 1; count <= 5; count++){
            bike.accelerate();
        }
        assertEquals(2, bike.getGear());
        assertEquals(31, bike.getSpeed());

        bike.accelerate();
        bike.accelerate();
        assertEquals(3, bike.getGear());
        assertEquals(37, bike.getSpeed());
        bike.decelerate();
        assertEquals(3, bike.getGear());
        assertEquals(34, bike.getSpeed());

    }

    @Test
    public void decelerateInGearFour_speedDecreasesByFour(){
        assertFalse(bike.isBikeOn());
        bike.toggle();
        assertTrue(bike.isBikeOn());
        assertEquals(0, bike.getGear());

        for(int count = 1; count <= 21; count++){
            bike.accelerate();
        }
        assertEquals(1, bike.getGear());
        assertEquals(21, bike.getSpeed());
        for (int count = 1; count <= 5; count++){
            bike.accelerate();
        }
        assertEquals(2, bike.getGear());
        assertEquals(31, bike.getSpeed());
        for(int count = 1; count <= 3; count++) {
            bike.accelerate();
        }
        assertEquals(3, bike.getGear());
        assertEquals(40, bike.getSpeed());

        bike.accelerate();
        assertEquals(3, bike.getGear());
        assertEquals(43, bike.getSpeed());

        bike.accelerate();
        assertEquals(4, bike.getGear());
        assertEquals(47, bike.getSpeed());

        bike.decelerate();
        assertEquals(4, bike.getGear());
        assertEquals(43, bike.getSpeed());
        bike.decelerate();
        assertEquals(4, bike.getGear());
        assertEquals(39, bike.getSpeed());

    }

}
