package mindfort;

public class Time2Test {
    public static void main(String[] args) {


        Time2 time = new Time2(23, 59, 59);

        displayTime("Default time", time);
        time.tick();
        displayTime("Default time", time);
        time.incrementMinute();
        displayTime("Default time", time);

        time.incrementHour();
        displayTime("Default time", time);

    }
    private static void displayTime(String header, Time2 t){
        System.out.printf("%s%n %s%n %s%n", header, t.toUniversalString(), t.toString());
    }

}


