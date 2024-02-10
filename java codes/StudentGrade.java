import java.util.Scanner;

  public class StudentGrade{

    public static void main(String[] args){

    int score;
    int highestScore = 0;
    String names = " ";
    int numberOfStudents = 0;
    int count = 1;

    Scanner input = new Scanner(System.in);

    System.out.println("Enter the number of students: ");
    numberOfStudents = input.nextInt();
    
    while (count <= numberOfStudents){
     System.out.print("Enter a student name: ");
     String name = input.next();
     System.out.println("Enter the students score: ");
     score = input.nextInt();

     
     if (score > highestScore){
      highestScore = score; 
      names = name;
     }
       count++;

   }


   System.out.printf("The student with the highest score is %s with a score of %d", names, highestScore);

    }



  }