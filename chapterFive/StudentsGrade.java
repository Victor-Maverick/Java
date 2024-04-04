import java.util.Scanner;
  public class StudentsGrade{

    public static void main(String[] args){

     Scanner input = new Scanner(System.in);

     int aCount = 0;
     int bCount = 0;
     int cCount = 0;



     for (int i = 1; i <= 5; i++){
      System.out.println("Enter a student's name and grade: ");
      String name = input.next();
      String grade = input.next();
      switch(grade){
      case "A" : 
       aCount++;
       break;
      case "B" : 
       bCount++;
       break;
      case "C" :
       cCount++;
       break;
      }

     }
   
     System.out.printf("number of A's : %d%nnumberof B's : %d%nnumber of C's : %d%n", aCount, bCount, cCount);
   }



  }