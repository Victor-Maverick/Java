public class StudentTest{

   public static void main(String[] args){

    Student account1 = new Student("Victor Orlu", 98.9);
    Student account2 = new Student("Peter Damian", 70.9);

    System.out.printf("%s's letter grade is %s%n", account1.getName(),            	account1.getLetterGrade());
    
    System.out.printf("%s's letter grade is %s%n", account2.getName(), 	account2.getLetterGrade());
 
 
   }








}