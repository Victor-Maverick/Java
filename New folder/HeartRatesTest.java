import java.util.Scanner;

public class HeartRatesTest{
 
   public static void main(String... args){

   HeartRates rate = new HeartRates();
  
   Scanner input = new Scanner(System.in);

   System.out.println("Enter your first name: ");
   String firstName = input.nextLine();
   rate.setFirstName(firstName);

   System.out.println("Enter your last name: ");
   String lastName = input.nextLine();
   rate.setLastName(lastName);
   
   System.out.println("Enter your year of birth: ");
   int yearOfBirth = input.nextInt();
   rate.setDobYear(yearOfBirth);
     
   System.out.println("Enter your month of birth: ");
   int monthOfBirth = input.nextInt();
   rate.setDobMonth(monthOfBirth);
   
    
   System.out.println("Enter your day of birth: ");
   int dayOfBirth = input.nextInt();
   rate.setDobDay(dayOfBirth);
   
   System.out.printf("%s %s's age is %d years%n", rate.getFirstName(), rate.getLastName(), rate.getAge());

   System.out.printf("The maximum heart rate is %d%n", rate.getMaxHeartRate());

   System.out.printf("The target-heart range is %.0f - %.0f ", rate.getLowerTargetRange(), rate.getUpperTargetRange());

   








}







}