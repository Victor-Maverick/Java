import java.util.Scanner;
  public class HighestGrade{

   public static void main(String[] args){

    

    int score = 0;
    int count = 0;
    String highestScorer = " ";
    int largest = 0;
    int numberOfStudent = 0;
    Scanner scanner = new Scanner(System.in);
 
    System.out.println("Enter the number of students: ");
    int numberOfStudents = scanner.nextInt();

    while(count <= numberOfStudents){
      System.out.println("Enter the name of the student: ");
      String name = scanner.next();
      System.out.println("Enter the Score of the student: ");
      score = scanner.nextInt();
      
      if(score > largest){
      score = largest;
      highestScorer = name;
        count++;
      }
       


    }

      System.out.printf("The student with the highest score is %s with a score of %d ", highestScorer, score);

   }



  }