import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeDivisiblesTest {
    @Test
    public void calculateSum(){
        ThreeDivisibles threeDivisibles = new ThreeDivisibles();
        assertEquals(165, threeDivisibles.calculateSumOfThreeDivisibles());

    }




}
