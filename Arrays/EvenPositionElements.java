import java.util.Arrays;
public class EvenPositionElements{

  public static int[] evenPositions(int[] array){
   
   int[] evenPositionArray = new int[array.length / 2]; 
   
   int index = 0;
   for(int count = 1; count < array.length; count+=2){
     evenPositionArray[index] = array[count];
     index++;
   }
      return evenPositionArray;
  }

  public static void main(String... args){
    int[] array = {6, 5, 3, 5, 7, 6, 3, 2, 9, 7, 4, 6};
    System.out.print(Arrays.toString(evenPositions(array)));
    
  }

}