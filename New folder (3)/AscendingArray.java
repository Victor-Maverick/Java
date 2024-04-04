import java.util.Arrays;
public class AscendingArray{

  public static int[] sortArray(int[] array){

     Arrays.sort(array);
     return array;

   }

  public static void main(String[] args){

    int[]  myArray = {5, 4, 7, 10, 50, 4}; 
    System.out.println(Arrays.toString(sortArray(myArray)));

  }



}