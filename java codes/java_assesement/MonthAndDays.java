import java.util.Scanner;
public class MonthAndDays{

public static void main (String[] args){

Scanner input = new Scanner(System.in);

System.out.println("Enter the month");
int monthOfYear = input.nextInt();


System.out.println("Enter the Year");
int theYear = input.nextInt();


if (monthOfYear==1)
System.out.printf("January %d has 31 days", theYear);

if (monthOfYear==2){
if (theYear%4==0)
System.out.printf("February %d has 29 days", theYear);
if (monthOfYear%4!=0)
System.out.printf("February %d has 28 days", theYear);
}

if (monthOfYear==3)
System.out.printf("March %d has 31 days", theYear);

if (monthOfYear==4)
System.out.printf("April %d has 30 days", theYear);

if (monthOfYear==5)
System.out.printf("May %d has 31 days", theYear);

if (monthOfYear==6)
System.out.printf("June %d has 30 days", theYear);

if (monthOfYear==7)
System.out.printf("July %d has 31 days", theYear);

if (monthOfYear==8)
System.out.printf("August %d has 31 days", theYear);

if (monthOfYear==9)
System.out.printf("September %d has 30 days", theYear);

if (monthOfYear==10)
System.out.printf("October %d has 31 days", theYear);

if (monthOfYear==11)
System.out.printf("November %d has 30 days", theYear);

if (monthOfYear==12)
System.out.printf("December %d has 31 days", theYear);


}








}