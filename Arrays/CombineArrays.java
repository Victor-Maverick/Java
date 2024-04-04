import java.util.Arrays;
public class CombineArrays{

  public static void main(String[] args){
   String[] array = {"a", "b", "c"};
   String[] myArray = {"1", "2", "3"};
   String[] newArray = new String[array.length + myArray.length];
   
   int ind = 0;
   int counter = 0;
   for(int count = 0; count < newArray.length; count+=2){
     newArray[count] = array[counter];
     counter++;
   }
  
   for(int index = 1; index < newArray.length; index+=2){
     newArray[index] = myArray[ind];
     ind++;
   }

   System.out.println(Arrays.toString(newArray));

  }

}