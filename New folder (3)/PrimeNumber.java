import java.util.Scanner;
public class PrimeNumber{
  private static Scanner scr = new Scanner(System.in);

  public static int getNumber(){
  
    System.out.println("Enter a positive number to check if it is a prime number: ");
    int number = scr.nextInt();
    while(number < 1){
      System.out.println("Enter a positive number to check if it is a prime number: ");
      number = scr.nextInt();
    }
      return number;
  }

  public static boolean checkPrimeNumber(int number){

    int counter =0;
    
    int length = (int)Math.ceil(number);


      for(int count = 1; count <= length; count++){
        if(number % count == 0){
	  counter++;
        }
      }

    if(counter <= 2){
      return true;
    }else{
      return false;
    }
  }

  public static void main(String[] args){

    int number = getNumber();
    System.out.println(checkPrimeNumber(number));

  }


}