import java.util.Scanner;
public class EvenOdd{

public static void main(String[] args){

Scanner input = new Scanner(System.in);

int sumOfOddIntegers=0;
int sumOfEvenIntegers=0;
int numberCount=0;
while (numberCount>=0){
System.out.println("Enter numbers, Enter -1 to stop");
int num = input.nextInt();
if (num==-1){
break;
}

if (num%2==0){
sumOfEvenIntegers=sumOfEvenIntegers+num;
numberCount=numberCount+1;
}

if (num%2!=0){
sumOfOddIntegers=sumOfOddIntegers+num;
numberCount=numberCount+1;
}




}

System.out.printf("The sum of odd integers is %d and the sum of even integers is %d", sumOfOddIntegers, sumOfEvenIntegers);

}






}