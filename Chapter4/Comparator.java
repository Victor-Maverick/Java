import java.util.Scanner;
  public class Comparator{

  public static void main(String[] args){

  Scanner sc = new Scanner(System.in);
  System.out.println("Enter two numbers: ");
  int numberOne = sc.nextInt();
  int numberTwo = sc.nextInt();

  if (numberOne == numberTwo){
    System.out.println("0");
  }
  else if (numberOne > numberTwo){
    System.out.println("1");
  }
  else if (numberOne < numberTwo){
     System.out.println("-1");
   }

  }


  }