import java.util.Scanner;
public class GlobalWarmingQuiz{

  public static void main(String[] args){

  Scanner scanner = new Scanner(System.in);

  int passCheck = 0;

   System.out.println("\nGlobal Warming brain tease\nThe Evidence for Rapid Climate Change is Compelling, kindly provide answers from option A-D\n");

   System.out.println("1. What is the effect of Global warming on Temperature?\nA.Global Temperature is increasing\nB.Global Temperature is decreasing\nC.Global Temperature remains unchanged\nD.Global Temperature is doubling");
   String firstAnswer = scanner.next();

   if(firstAnswer.equalsIgnoreCase("A")){
      passCheck++;
   }

   System.out.println("\n2. Due to Global warming, the ocean is getting?\nA.Colder\nB.Warmer\nC.Deeper\nD.Shallower");
   String secondAnswer = scanner.next();

   if(secondAnswer.equalsIgnoreCase("B")){
     passCheck++;
   }

   System.out.println("\n3. What is an effect of Global warming on Greenland and Antarctic ice sheets?\nA.Ice sheets are shrinking\nB.ice sheets are expanding\nC.Ice sheets remain unchanged\nD.Ice sheets are spreading");
   String thirdAnswer = scanner.next();

   if(thirdAnswer.equalsIgnoreCase("A")){
     passCheck++;
   }

   System.out.println("\n4. With the current rate of global warming, snow cover is gradually __\nA.Increasing\nB.Unchanged\nC.Decreasing\nD.Covering trees");
   String fourthAnswer = scanner.next();

   while(fourthAnswer.equalsIgnoreCase("C")){
     passCheck++;
   }

   System.out.println("\n5.Global warming has caused a/an ___ in Sea level\nA.Fall\nB.Even Level\nC.Rise\nD.No change");
   String fifthAnswer = scanner.next();

   if(fifthAnswer.equalsIgnoreCase("C")){
     passCheck++;
   }

   if(passCheck == 5){
     System.out.println("\nExcellent");
   }
   else if(passCheck == 4){
     System.out.println("\nVery good");
   }
   else if(passCheck <= 3){
     System.out.println("\nTime to brush up on your knowledge of global warming");
   }

   System.out.println("\nWebsite: www.climate.nasa.gov");
  }

}