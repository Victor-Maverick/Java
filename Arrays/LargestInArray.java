import java.util.Arrays;
public class LargestInArray{

  public static void intArrayLargest(){
   int[] array = {4, 2, 10, 13, 9, 11};
   
   int largest = 0;
    for(int index = 0; index < array.length; index++){
     if(array[index] > largest){
      largest = array[index];
     } 
    }
     System.out.println(Arrays.toString(array));
     System.out.printf("The largest element in the list is %d%n", largest);
  }

  public static void main(String... args){
   intArrayLargest();
  }


}