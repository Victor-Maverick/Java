import java.util.Scanner;
public class IncreasingOrder{

public static void main(String... args){

Scanner scanner = new Scanner(System.in);

System.out.println("Enter three integers");
int numberOne = scanner.nextInt();
int numberTwo = scanner.nextInt();
int numberThree = scanner.nextInt();

if (numberOne > numberTwo && numberTwo > numberThree)
System.out.printf("%d %d %d", numberThree, numberTwo, numberOne);

if (numberTwo > numberOne && numberOne > numberThree)
System.out.printf("%d %d %d", numberThree, numberOne, numberTwo);

if (numberThree > numberTwo && numberTwo > numberOne)
System.out.printf("%d %d %d", numberOne, numberTwo, numberThree);

if (numberOne > numberThree && numberThree > numberTwo)
System.out.printf("%d %d %d", numberTwo, numberThree, numberOne);

if (numberTwo > numberThree && numberThree > numberOne)
System.out.printf("%d %d %d", numberOne, numberThree, numberTwo);

if (numberThree > numberOne && numberOne > numberTwo)
System.out.printf("%d %d %d", numberTwo, numberOne, numberThree);







}




}