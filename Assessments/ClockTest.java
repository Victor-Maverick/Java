import java.util.Scanner;
public class ClockTest{

public static void main(String... args){

Clock Clock1 = new Clock(12, 30, 33);

Scanner scanner = new Scanner(System.in);

System.out.println("Enter the hour: ");
int numberOfHours = scanner.nextInt();

System.out.println("Enter the minutes: ");
int numberOfMinutes = scanner.nextInt();

System.out.println("Enter the seconds: ");
int numberOfSeconds = scanner.nextInt();
Clock1.displayTime();






}






}