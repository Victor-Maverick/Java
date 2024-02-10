import java.util.Scanner;

public class Zeller{

public static void main(String... args){

Scanner scanner = new Scanner(System.in);

System.out.println("Enter year: (e.g 2012)");
int year = scanner.nextInt();

System.out.println("Enter month: 1-12: ");
int month = scanner.nextInt();

System.out.println("Enter day of the month: 1-31: ");
int dayOftheMonth = scanner.nextInt();

int century = year / 100;
int yearOfTheCentury = year % 100;
int resultOfMonth = 26 * (month + 1) /10;
int resultOfYearOfCentury = yearOfTheCentury + (yearOfTheCentury / 4);
int resultOfCentury = (century / 4) + (5 * century);
int dayOfTheWeek = (dayOftheMonth + resultOfMonth + resultOfYearOfCentury + resultOfCentury) % 7;

if (dayOfTheWeek==0)
System.out.println("Day of the week is Saturday");

if (dayOfTheWeek==1)
System.out.println("Day of the week is Sunday");

if (dayOfTheWeek==2)
System.out.println("Day of the week is Monday");

if (dayOfTheWeek==3)
System.out.println("Day of the week is Tuesday");

if (dayOfTheWeek==4)
System.out.println("Day of the week is Wednesday");

if (dayOfTheWeek==5) 
System.out.println("Day of the week is Thursday");

if (dayOfTheWeek==6)
System.out.println("Day of the week is Friday");












}





}