import java.util.Scanner;
  public class TwoLargest{

  public static void main(String... args){

  Scanner scanner = new Scanner(System.in);
  
  int largest = 0;
  int secondLargest = 0;
  int counter = 1;
  while (counter <= 10){
   System.out.print("Enter a number: you may each number only once: ");
   int number = scanner.nextInt();

   if (number > largest){
      secondLargest = largest;
      largest = number;
   }
   if (number < secondLargest){
    secondLargest = number;
   }
    counter++;

  }


   System.out.printf("The largest number is %d and the second largest number is %d", largest, secondLargest);



  }







  }