import java.util.Scanner;
public class StudentGrade{
   private static int[][] grades;
   private String courseName;

   public StudentGrade(int[][] grades, String courseName){
     this.grades = grades;
     this.courseName = courseName;
   }

   public static double getAverage(int[] gradeSet){
   int total = 0;
   for (int grade : gradeSet){
    total+=grade;
   }
   return (double)total / gradeSet.length;

  }

  public static int getTotal(int[] setOfGrades){
   int total = 0;
   for(int grade : setOfGrades){
    total+= grade;
   }
    return total;
  }

  public static int getHighest(int subject){
   int highest = 0;
   int row = 0;
   for (row=0; row<grades.length; row++){ 
      
	for(int column = 0; column<grades[row].length; column++){
          if (grades[row][subject] > highest){
	    highest = grades[row][subject];
	}            
     }
    
  } 
 return highest;
}

  public static void getSubjectSummary(){
    int highest = 0;
     for(int subject=0; subject<grades[0].length; subject++){
       System.out.println("SUBJECT SUMMARY");
	System.out.printf("Subject %d", subject +1);
 	 highest = getHighest(subject);
     }
	System.out.printf("%d", highest);
  }

 public void processGrades(){
  
  Scanner scanner = new Scanner(System.in);
  System.out.println("How many students do you have? ");
  int numberOfStudents = scanner.nextInt();

  System.out.println("How many subjects do they offer? ");
  int numberOfSubjects = scanner.nextInt();
  
  System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>\nSaved successfully");
  
  int[][] grades = new int[numberOfStudents][numberOfSubjects];
  
  for(int count=0; count<grades.length; count++){
  System.out.printf("entering scores for Student %2d%n", count +1);
   for (int score = 0; score < grades[count].length; score++){
     System.out.printf("enter scores for Subject %2d%n", score +1);
     grades[count][score] = scanner.nextInt();
     System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>\nSaved successfully");
   }
    
 }
  System.out.print("               ");
  for(int test=0; test<grades[0].length; test++){
   System.out.printf("SUB %d	", test +1);
  }

  System.out.printf("TOT	");
  System.out.printf("AVE	");
  System.out.printf("POS%n");

  for(int student=0; student<grades.length; student++){
    System.out.printf("Student%d	", student +1);

    for(int grade : grades[student]){
     System.out.printf("%d	", grade);
    }
    int total = getTotal(grades[student]);
    System.out.printf("%d	", total);

    for (int grade : grades[student]){
    
    }
    double average = getAverage(grades[student]);
     System.out.printf("%.1f	", average);
    
    int position = 1;
    for(int count=0; count<grades.length; count++){
     	
      if(total < getTotal(grades[count])){
       position++;
      }
      
     }
     System.out.printf("%3d%n", position);
     }
  
     getSubjectSummary();
}
}