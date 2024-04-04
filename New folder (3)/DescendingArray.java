import java.util.Arrays;
public class DescendingArray{

  public static int[] sortArray(int[] array){

     Arrays.sort(array);

     int[] newArray = new int[array.length];
     int index = 0;

       for(int count = newArray.length-1; count >= 0;  count--){
    	 newArray[index] = array[count];
	 index++;
       }

     return newArray;

   }

  public static void main(String[] args){

    int[]  myArray = {5, 4, 7, 10, 50, 4}; 
    System.out.println(Arrays.toString(sortArray(myArray)));

  }



}