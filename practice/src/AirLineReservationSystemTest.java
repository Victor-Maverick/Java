import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class AirLineReservationSystemTest {


    private boolean[] testSeatNumber = new boolean[]{false, false, false, false, false, false, false, false, false, false};

    @Test
    public void testThatAirLineReservationSystemExist(){

        AirLineReservationSystem reservationSystem = new AirLineReservationSystem();
        assertNotNull(reservationSystem);

    }
    @Test
    public void testThatSeatsAreFirstAssignedDummyValues(){

        AirLineReservationSystem reservationSystem = new AirLineReservationSystem();
        boolean[] seatNumber = reservationSystem.assignDefaultSeatNumber();
        assertArrayEquals(testSeatNumber, seatNumber);
    }

   /* @Test
    public void testThatSeatsAreAssignedFirstClassSeat(){

        AirLineReservationSystem airLineReservationSystem = new AirLineReservationSystem();
        boolean condition = airLineReservationSystem.assignSeatNumber(1);
        assertTrue(condition);

    }*/
}