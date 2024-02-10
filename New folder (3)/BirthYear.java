import java.util.Scanner;
import java.util.InputMismatchException;

public class BirthYear{

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);    

    
    try{

     System.out.println("Enter your year of birth: ");
     int birthYear =  input.nextInt();

     while(birthYear < 0){
       System.out.println("Enter your year of birth: ");
        birthYear =  input.nextInt();
     }
     int currentYear = 2024;
     int age = currentYear - birthYear;

    System.out.printf("You are %d years old%n", age);
    }
    catch(InputMismatchException e){
      System.out.printf("Enter integer only ");

    }
  }



}