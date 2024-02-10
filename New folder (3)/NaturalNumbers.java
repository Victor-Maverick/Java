public class NaturalNumbers{

  public static void main(String[]  args){
   
    int sumOfNaturalNumbers = 0;

      for(int count = 1; count <= 10; count++){
      
        sumOfNaturalNumbers += count;
      }
     
      System.out.printf("The sum of the first Ten natural numbers is %d%n", sumOfNaturalNumbers);

  }



}