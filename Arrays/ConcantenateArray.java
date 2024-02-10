import java.util.Arrays;
public class ConcantenateArray{

  public static void main(String... args){
   String[] myArray = {"a", "b", "c"};
   String [] array = {"1", "2", "3"};
   String[] newArray = new String[myArray.length + array.length];

    int index = 0;
   for(int count = 0; count < myArray.length; count++){
     newArray[count] = myArray[index];
     index++;
   }

    int ind = 0;
   for(int count = myArray.length; count < newArray.length; count++){
     newArray[count] = array[ind];
     ind++;
   } 

   System.out.println(Arrays.toString(newArray));
  }

}