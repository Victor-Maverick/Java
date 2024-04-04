public class Student1Test{

  public static void main(String... args){

  Student student1 = new Student("Aquinas", 90);
  Student student2 = new Student("Quiba", 87);
  
  System.out.printf("%s's grade in the course is %s", student1.getName(), student1.getLetterGrade()); 

  System.out.printf("%s's grade in the course is %s", student2.getName(), student2.getLetterGrade()); 




  }





}