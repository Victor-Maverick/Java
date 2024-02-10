import mindfort.Cylinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CylinderTest {
    private Cylinder cylinder;

    @BeforeEach
    public void setup(){
        cylinder = new Cylinder();
    }

    @Test
    public void setNegativeRadius_radiusRemainsUnchangedTest(){
        cylinder.setRadius(-100);
        assertEquals(1, cylinder.getRadius());

    }

    @Test
    public void setPositiveRadius_radiusTakesNewValueTest(){
        cylinder.setRadius(10);
        assertEquals(10, cylinder.getRadius());

    }

    @Test
    public void setNegativeHeight_heightRemainsUnchangedTest(){
        cylinder.setHeight(-100);
        assertEquals(1, cylinder.getHeight());

    }

    @Test
    public void setPositiveHeight_heightTakesNewValueTest(){
        cylinder.setHeight(10);
        assertEquals(10, cylinder.getHeight());

    }

}
