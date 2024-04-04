import java.util.Scanner;
public class StudentGradeTest{

  public static void main(String[] args){

  Scanner scanner = new Scanner(System.in);
  System.out.println("How many students do you have? ");
  int numberOfStudents = scanner.nextInt();

  System.out.println("How many subjects do they offer? ");
  int numberOfSubjects = scanner.nextInt();
  
  System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>\nSaved successfully");
  
  int[][] grades = new int[numberOfStudents][numberOfSubjects];

  StudentGrade studentGrade = new StudentGrade(grades);

  studentGrade.processGrades();

  }




}