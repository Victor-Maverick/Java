import java.util.Scanner;
public class ZeroPositive{

public static void main(String[] args){
Scanner scanner = new Scanner(System.in);

int positiveNumbers=0;
int negativeNumbers=0;
int zeroNumbers=0;
int numberCounter=1;

while (numberCounter <= 5){
System.out.println("Enter your numbers ");
int num = scanner.nextInt();


if (num>0){
positiveNumbers = positiveNumbers + 1;
numberCounter = numberCounter + 1;
}
if (num<0){
negativeNumbers = negativeNumbers + 1;
numberCounter = numberCounter + 1;
}

if (num==0){
zeroNumbers = zeroNumbers + 1;
numberCounter = numberCounter + 1;
}

}

System.out.printf("There are %d positive numbers, %d negative numbers, %d zero numbers", positiveNumbers, negativeNumbers, zeroNumbers);

 


}

}