import java.util.Arrays;
public class OddPositionElements{

  public static int[] oddPositions(int[] array){
   int length = 0;
   if(array.length % 2 == 0){
     length = array.length / 2;
   }
   else{
     length = array.length / 2 + 1;
   }
   int[] oddPositionArray = new int[length]; 
   
   int index = 0;
   for(int count = 0; count < array.length; count+=2){
     oddPositionArray[index] = array[count];
     index++;
   }
      return oddPositionArray;
     //System.out.println(Arrays.toString(oddPositionArray));
  }

  public static void main(String... args){
    int[] array = {6, 5, 3, 5, 7, 6, 3, 2, 9, 7, 6};
    System.out.print(Arrays.toString(oddPositions(array)));
    
  }

}