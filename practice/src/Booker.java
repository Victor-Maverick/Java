public class Booker{
    private int id;
    public Booker(int id){

        this.id = id;
    }

    public void book(AirLineReservationSystem airLineReservationSystem){
        airLineReservationSystem.assignSeatNumber(this.id);
    }
}