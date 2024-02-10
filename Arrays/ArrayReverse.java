import java.util.Arrays;
public class ArrayReverse{

  public static void main(String[] args){
    reverseIntArray();
    reverseStringArray();
  }  

  public static void reverseIntArray(){
    int[] myArray = {3, 9, 19, 4, 5};
    int[] reversedMyArray = new int[myArray.length];
    
     int index = 0;
     for(int count = myArray.length - 1; count >= 0; count--){
       reversedMyArray[index] = myArray[count];
       //System.out.printf("%d ", reversedMyArray[index]);
        index++;
     }
       System.out.println(Arrays.toString(myArray));
       System.out.println(Arrays.toString(reversedMyArray));
       System.out.println();
  }
  
  public static void reverseStringArray(){
    String[] newArray = {"M", "a", "v", "e", "r", "i", "c", "k"};
    String[] reversedNewArray = new String[newArray.length]; 
  
    int index = 0;
     for(int count = newArray.length - 1; count >= 0; count--){
       reversedNewArray[index] = newArray[count];
       index++;
     }
      System.out.println(Arrays.toString(newArray));
      System.out.print(Arrays.toString(reversedNewArray));
  }
}