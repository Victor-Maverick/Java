public class ClockTest{

public static void main(String... args){

Clock clock1 = new Clock(20, 44, 43);
Clock clock2 = new Clock(12, 34, 33);

System.out.printf("The time is %s: ", clock1.displayTime());
System.out.printf("The time is %s: ", clock2.displayTime());


}



}