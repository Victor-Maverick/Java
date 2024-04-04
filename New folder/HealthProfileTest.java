import java.util.Scanner;
   public class HealthProfileTest{

   public static void main(String... args){

   HealthProfile health = new HealthProfile();
 
   Scanner input = new Scanner(System.in);
 
   System.out.println("Enter your first name: ");
   String firstName = input.nextLine();
   health.setFirstName(firstName);
   health.getFirstName();

   System.out.println("Enter your last name: ");
   String lastName = input.nextLine();
   health.setLastName(lastName);
   health.getLastName();

   System.out.println("Enter your gender:(Male or Female): ");
   String gender = input.nextLine();
   health.setGender(gender);
   health.getGender();

   System.out.println("Enter your Date of birth: Year: ");
   int dobYear = input.nextInt();
   health.setDobYear(dobYear);
   health.getDobYear();

   System.out.println("Month: ");
   int dobMonth = input.nextInt();
   health.setDobMonth(dobMonth);
   health.getDobMonth();
   
   System.out.println("Day: ");
   int dobDay = input.nextInt();
   health.setDobDay(dobDay);
   health.getDobDay();  
 
   System.out.println("Enter your height in inches ");
   double height = input.nextDouble();
   health.setHeight(height);
   health.getHeight();

   System.out.println("Enter your weight in kilograms ");
   double weight = input.nextDouble();
   health.setWeight(weight);
   health.getWeight();

   System.out.printf("%s %s %s %d years%nThe BMI is %.2f%nThe maximum heart rate is %d%nThe target-heart-range is %.2f - %.2f", health.getFirstName(), health.getLastName(), health.getGender(), health.getAge(), health.getBodyMassIndex(), health.getMaxHeartRate(), health.getLowerTargetRange(), health.getUpperTargetRange());




  }






}